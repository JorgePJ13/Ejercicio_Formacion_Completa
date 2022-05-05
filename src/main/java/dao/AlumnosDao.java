package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;
import model.Curso;

public interface AlumnosDao extends JpaRepository<Alumno, String> { // JpaRepository<Entity, Tipo>

	/**
	 * Metodo que devuelve un alumno según su usuario y contraseña
	 * 
	 * @param usuario  nombre del usuario
	 * @param password contraseña del usuario
	 * @return el alumno a buscar a partir de su usuario y contraseña
	 */
	Alumno findByUsuarioAndPassword(String usuario, String password);

	/**
	 * Metodo que devuelve los alumnos que están matriculados en un curso
	 * 
	 * @param nombreCurso nombre del curso a buscar
	 * @return una lista de alumnos segun el nombre del curso
	 */
	@Query("select a from Alumno a join a.matriculas m where m.curso.nombre=?1")
	List<Alumno> findByCurso(String nombreCurso);

	/**
	 * Método que indica si el nombre del curso está o no para darse de alta
	 * 
	 * @param nombre: nombre del curso que puede darse de alta
	 * @return el curso a dar de alta
	 */
	Optional<Alumno> findByNombre(String nombre);
}
