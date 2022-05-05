package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Curso;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlumnoDto { // DTO se usa para transferir datos entre capas y aislar el controller del uso
							// de entidades
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;
}
