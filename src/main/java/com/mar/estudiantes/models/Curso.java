package com.mar.estudiantes.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id	
	private String codigoCurso; 
	
	private LocalDate fechaInicio; 
	private LocalDate fechaTermno; 
	
	@OneToMany(mappedBy = "idEstudiante")
	@JsonIgnore
	private List<Estudiante> estudiantes;
	
	@ManyToOne
	@JoinColumn(name = "codigo_plan_formativo")
	private PlanFormativo plan;
	
	@ManyToOne
	@JoinColumn(name = "codigo_comuna")
	private Comuna comuna;
	
}
