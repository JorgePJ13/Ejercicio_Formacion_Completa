package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // implementa lombok los metodos hashCode y equals
@Embeddable
public class MatriculaPK implements Serializable {

	private String usuario;
	private int idCurso;

}
