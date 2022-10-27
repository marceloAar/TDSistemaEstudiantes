package com.mar.estudiantes.models;

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
@Table(name = "comuna")
public class Comuna {

	@Id
	private Integer codigoComuna; 
	
	private String nombre; 
	
	@OneToMany(mappedBy = "idEstudiante")
	@JsonIgnore
	private List<Estudiante> estudiantes;
	
	@ManyToOne
	@JoinColumn(name = "codigo_region")
	private Region region;	
	
}
