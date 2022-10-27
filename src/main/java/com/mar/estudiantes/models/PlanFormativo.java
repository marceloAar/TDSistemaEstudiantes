package com.mar.estudiantes.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data

@Entity
@Table(name = "plan_formativo")
public class PlanFormativo {
	
	@Id
	private String codigoPlanFormativo;
	
	private String descripcion; 
	private int duracionHoras;
	
	@OneToMany(mappedBy = "codigoCurso")
	@JsonIgnore
	private List<Curso> cursos;		

}
