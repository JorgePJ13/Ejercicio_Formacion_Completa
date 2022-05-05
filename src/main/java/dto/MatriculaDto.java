package dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatriculaDto {

	private CursoDto cursoDto;
	private AlumnoDto alumnoDto;
	private double nota;
}
