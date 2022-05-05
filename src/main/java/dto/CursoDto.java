package dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//DTO se usa para transferir datos entre capas y aislar el controller del uso de entidades
public class CursoDto { // las clases DTO son clases neutras, no tiene anotaciones de persistencia

	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private Date fechaInicio;
}
