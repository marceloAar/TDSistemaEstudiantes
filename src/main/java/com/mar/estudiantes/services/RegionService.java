package com.mar.estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.estudiantes.models.Region;
import com.mar.estudiantes.repositories.RegionRepository;

@Service
public class RegionService {
	
	@Autowired
	private RegionRepository regionRepo;
	
	public List<Region> allRegiones(){
		return regionRepo.findAll();
	}

}
