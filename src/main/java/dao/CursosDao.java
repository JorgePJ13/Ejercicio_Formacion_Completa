package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dto.CursoDto;
import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	/**
	 * Metodo que devuelve la lista de cursos en donde está matriculado un alumno
	 * 
	 * @param usuario nombre del usuario a buscar en los cursos
	 * @return lista de cursos donde esta matriculado el alumno
	 */
	@Query("select distinct(c) from Curso c join c.matriculas m where m.alumno.usuario=?1")
	List<Curso> findByAlumno(String usuario);

	/**
	 * Método que indica si el nombre del curso está o no para darse de alta
	 * 
	 * @param nombre: nombre del curso que puede darse de alta
	 * @return el curso a dar de alta
	 */
	Optional<Curso> findByNombre(String nombre);

	/**
	 * Método que indica los cursos donde no esta matriculado un alumno para poder
	 * matricularse
	 * 
	 * @param usuario: nombre del usuario
	 * @return la lista de cursos donde no esta matriculado el usuario
	 */
	@Query("select c from Curso c where c not in (select c from Curso c join c.matriculas m where m.alumno.usuario=?1)")
	// Segundo select indica donde esta matriculado el alumno
	// primer select indica los cursos cuyo curso NO ESTE en esa lista
	List<Curso> findCursoNoAlumno(String usuario);

}
