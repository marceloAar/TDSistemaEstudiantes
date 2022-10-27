package com.mar.estudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mar.estudiantes.models.Estudiante;
import com.mar.estudiantes.models.PlanFormativo;
import com.mar.estudiantes.models.Region;
import com.mar.estudiantes.services.EstudianteService;
import com.mar.estudiantes.services.PlanFormativoService;
import com.mar.estudiantes.services.RegionService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private PlanFormativoService planService;
	
	@Autowired
	private RegionService regionService;
	
	
	@GetMapping("/estudiantes") 	//http://localhost:8080/estudiantes
	public String listarEstudiantes(Model model) {
		List<Estudiante> estudiantes = estudianteService.allEstudiantes();
		List<PlanFormativo> planes = planService.allPlanes();
		List<Region> regiones = regionService.allRegiones();
		
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("planes", planes);
		model.addAttribute("regiones", regiones);
		
		return "index";
	}
	
	
	@PostMapping("/filtrar")
	public String filtraEstudiantes(@RequestParam(value = "region") Integer region, 
									@RequestParam(value = "curso") String curso,
									Model model) {
		
		List<Estudiante> filtros = estudianteService.filtraTotal(region, curso);		
		List<PlanFormativo> planes = planService.allPlanes();
		List<Region> regiones = regionService.allRegiones();
		
		model.addAttribute("estudiantes", filtros);
		model.addAttribute("planes", planes);
		model.addAttribute("regiones", regiones);
		
		return "index";
	}
}
