package com.mar.estudiantes.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id	
	private Integer idEstudiante; 
		
	private String rut; 
	private String nombre; 
	private String apellidoPat; 
	private String apellidoMat; 
	private String direccion; 
	
	@ManyToOne
	@JoinColumn(name = "codigo_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "codigo_comuna")
	private Comuna comuna;
	
}
