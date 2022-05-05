package converters;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;

public interface ConversorEntityDto {

	// Convierte de objeto Curso a DTO
	public CursoDto cursoToDto(Curso curso);

	// Convierte de DTO a objeto Curso
	public Curso dtoToCurso(CursoDto dto);

	// Convierte de objeto Alumno a DTO
	public AlumnoDto alumnoToDto(Alumno alumno);

	// Convierte de DTO a objeto Alumno
	public Alumno dtoToAlumno(AlumnoDto dto);
	
	// Convierte de objeto Matricula a DTO
	public MatriculaDto matriculaToDto(Matricula matricula);
	
	// Convierte de DTO a objeto Matricula
	public Matricula dtoToMatricula(MatriculaDto dto);
}
