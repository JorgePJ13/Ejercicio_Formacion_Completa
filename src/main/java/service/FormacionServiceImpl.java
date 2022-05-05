package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculasDao;
import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPK;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	ConversorEntityDto conversor;

	AlumnosDao alumnosDao;

	CursosDao cursosDao;

	MatriculasDao matriculasDao;

	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao,
			@Autowired MatriculasDao matriculasDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
		this.matriculasDao = matriculasDao;
	}

	@Override
	public AlumnoDto validarUsuario(String usuario, String password) {
		return conversor.alumnoToDto(alumnosDao.findByUsuarioAndPassword(usuario, password));
	}

	@Override
	public List<CursoDto> listaCursosAlumnoMatriculado(String usuario) {
		return cursosDao.findByAlumno(usuario).stream().map(c -> conversor.cursoToDto(c)).collect(Collectors.toList());
		// con stream transformamos la lista de cursos a lista de cursosDto
	}

	@Override
	public List<CursoDto> listaCursos() {
		return cursosDao.findAll().stream().map(c -> conversor.cursoToDto(c)).collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> listaAlumnos() {
		return alumnosDao.findAll().stream().map(a -> conversor.alumnoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> listaAlumnosMatriculadosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso).stream().map(a -> conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		/*
		 * Curso curso = cursosDao.findById(idCurso).orElse(null); // orElse te devuelve
		 * el curso, si no se encuentra se // mete null a la variable Alumno alumno =
		 * alumnosDao.findById(usuario).orElse(null); if (curso != null && alumno !=
		 * null) { alumno.getCursos().add(curso); // a los cursos del alumno se le añade
		 * el curso alumnosDao.save(alumno); // se actualiza el alumno return true; }
		 * return false;
		 */
		// Vamos a hacerlo con Optional (igual que arriba pero más optimo)
		Optional<Curso> curso = cursosDao.findById(idCurso); // orElse te devuelve el curso, si no se encuentra se
		// mete null a la variable
		Optional<Alumno> alumno = alumnosDao.findById(usuario);
		if (curso.isPresent() && alumno.isPresent()) { // en vez de null, se pregunta si esta presente
			matriculasDao.save(new Matricula(new MatriculaPK(usuario, idCurso), 0, curso.get(), alumno.get()));
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean altaAlumno(AlumnoDto a) {
		Optional<Alumno> alumno = alumnosDao.findByNombre(a.getNombre());
		if(!alumno.isPresent()) {
			alumnosDao.save(conversor.dtoToAlumno(a));
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean altaCurso(CursoDto c) {
		Optional<Curso> curso = cursosDao.findByNombre(c.getNombre());
		if(!curso.isPresent()) {
			cursosDao.save(conversor.dtoToCurso(c));
			return true;
		}
		return false;
	}

	@Override
	public List<MatriculaDto> consultarMatriculas(Date f1, Date f2) {
		return matriculasDao.findMatriculasFechas(f1, f2).stream().map(m -> conversor.matriculaToDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursosPosiblesMatricularAlumno(String usuario) {
		return cursosDao.findCursoNoAlumno(usuario).stream().map(c -> conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

}
