package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService service;

	@PostMapping("Login")
	public String loginAlumno(@ModelAttribute AlumnoDto a) {
		AlumnoDto alumno = service.validarUsuario(a.getUsuario(), a.getPassword());
		if (alumno != null) {
			return "menu";
		} else {
			return "login";
		}
	}

	@GetMapping(value = "Alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnos() {
		return service.listaAlumnos();
	}

	@GetMapping(value = "Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursos() {
		return service.listaCursos();
	}

	@GetMapping(value = "AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnosCurso(@RequestParam("nombre") String nombreCurso) {
		return service.listaAlumnosMatriculadosCurso(nombreCurso);
	}

	@GetMapping(value = "CursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursosAlumno(@RequestParam("usuario") String usuario) {
		return service.listaCursosAlumnoMatriculado(usuario);
	}

	@PostMapping(value = "AltaCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public String altaCurso(@ModelAttribute CursoDto curso,
			@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio) {
		curso.setFechaInicio(fechaInicio);
		return service.altaCurso(curso) ? "menu" : "insertarCurso";
	}

	@PostMapping(value = "AltaAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public String altaAlumno(@ModelAttribute AlumnoDto alumno) {
		return service.altaAlumno(alumno) ? "menu" : "insertarAlumno";
	}

	/*
	 * @GetMapping(value = "Matriculas", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody List<Curso>
	 * matriculas(@RequestParam("fechaIni") String fechaIni,
	 * 
	 * @RequestParam("fechaFin") String fechaFin) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); // indicamos el formato de la fecha try {
	 * return service.consultarMatriculas(sdf.parse(fechaIni), sdf.parse(fechaFin));
	 * } catch (ParseException e) { e.printStackTrace(); return null; } }
	 */

	// Otra forma de capturar las fechas
	@GetMapping(value = "Matriculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MatriculaDto> matriculas(
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
		return service.consultarMatriculas(fechaIni, fechaFin);
	}

	@PostMapping(value = "Matricular", produces = MediaType.APPLICATION_JSON_VALUE)
	public String matricularAlumno(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario,
			HttpSession session) {
		if (service.matricularAlumno(usuario, idCurso)) {
			return "matricular";
		} else {
			session.setAttribute("error", "Error al matricular alumno");
			return "menu";
		}
	}

	@GetMapping(value = "CursosNoMatriculado", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursosNoMatriculados(@RequestParam("usuario") String usuario)
			throws ParseException {
		return service.cursosPosiblesMatricularAlumno(usuario);
	}
}
