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
@Table(name = "region")
public class Region {

	@Id
	private Integer codigoRegion;
	
	private String nombre;
	
	@OneToMany(mappedBy = "codigoComuna")
	@JsonIgnore
	private List<Comuna> comunas;
}
