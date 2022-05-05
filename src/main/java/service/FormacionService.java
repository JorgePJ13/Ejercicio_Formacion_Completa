	package service;

import java.util.Date;
import java.util.List;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;

public interface FormacionService {

	/**
	 * Dado un usuario y contrase�a, se obtiene los datos del alumno
	 * 
	 * @param usuario
	 * @param password
	 * @return Devuelve un usuario segun su usuario y contrase�a
	 */
	AlumnoDto validarUsuario(String usuario, String password);

	/**
	 * Devuelve la lista de cursos en donde est� matriculado un alumno
	 * 
	 * @param usuario
	 * @return los cursos en los que se matricul� el alumno
	 */
	List<CursoDto> listaCursosAlumnoMatriculado(String usuario);

	/**
	 * Devuelve la lista de cursos que hay en la BBDD
	 * 
	 * @return la lista de cursos
	 */
	List<CursoDto> listaCursos();

	/**
	 * Devuelve la lista de cursos que hay en la BBDD
	 * 
	 * @return la lista de cursos
	 */
	List<AlumnoDto> listaAlumnos();

	/**
	 * Devuelve los alumnos que est�n matriculados en un curso
	 * 
	 * @param nombreCurso
	 * @return la lista de alumnos matriculados en un determinado curso
	 */
	List<AlumnoDto> listaAlumnosMatriculadosCurso(String nombreCurso);

	/**
	 * M�todo que matricula a un alumno en un curso
	 * 
	 * @param usuario
	 * @param idCurso
	 * @return true si se ha matriculado con exito
	 */
	boolean matricularAlumno(String usuario, int idCurso);

	/**
	 * Metodo que da de alta un alumno (sin repetir usuario)
	 * 
	 * @param a: alumno a dar de alta
	 * @return true si se da alta el alumno; false en caso contrario
	 */
	boolean altaAlumno(AlumnoDto a);

	/**
	 * Metodo que da de alta un curso (sin repetir el nombre del curso)
	 * 
	 * @param c: curso a dar de alta
	 * @return true si se da de alta el curso; false en caso contrario
	 */
	boolean altaCurso(CursoDto c);

	/**
	 * Metodo que devuelve los cursos comprendido entre dos fechas
	 * 
	 * @param f1: fecha de inicio del curso
	 * @param f2: fecha de fin del curso
	 * @return la lista de cursos que hay entre las dos fechas
	 */
	List<MatriculaDto> consultarMatriculas(Date f1, Date f2);

	/**
	 * Metodo que indica los cursos donde no esta matriculado un alumno
	 * 
	 * @param usuario: nombre del usuario a matricular
	 * @return la lista de cursos donde no esta matriculado el alumno
	 */
	List<CursoDto> cursosPosiblesMatricularAlumno(String usuario);
	
	/**
	 * Metodo que busca un alumno segun su nombre de usuario
	 * 
	 * @param usuario
	 * @return el alumno a buscar
	 */
	// Alumno buscarAlumno(String usuario);

	/**
	 * M�todo que busca un curso seg�n su identificador en la BBDD
	 * 
	 * @param idCurso
	 * @return el curso a buscar
	 */
	// Curso buscarCurso(int idCurso);

}
