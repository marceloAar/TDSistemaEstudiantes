package com.mar.estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.estudiantes.models.PlanFormativo;
import com.mar.estudiantes.repositories.PlanFormativoRepository;

@Service
public class PlanFormativoService {

	@Autowired
	private PlanFormativoRepository planRepo;
	
	public List<PlanFormativo> allPlanes(){
		return planRepo.findAll();
	}
}
