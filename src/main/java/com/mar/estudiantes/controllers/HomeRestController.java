package com.mar.estudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mar.estudiantes.models.Estudiante;
import com.mar.estudiantes.services.EstudianteService;

@RestController
@RequestMapping("/api/v1")
public class HomeRestController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	 
	@GetMapping("/estudiantes") 	// http://localhost:8080/api/v1/estudiantes
	public List<Estudiante> home() {
		
		List<Estudiante> estudiantes = estudianteService.allEstudiantes();
		
		return estudiantes;
	}	
	
	
	@GetMapping("/estudiantes/buscar")		// http://localhost:8080/api/v1/estudiantes/buscar?region=" "&curso=" "
	public List<Estudiante> filtrar(@RequestParam(value = "region", defaultValue = "0") Integer region, 
									@RequestParam(value = "curso", defaultValue = "0") String curso) {
		
		List<Estudiante> filtros = estudianteService.filtraTotal(region, curso);

		return filtros;
	}

}
