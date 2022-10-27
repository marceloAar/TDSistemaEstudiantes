package com.mar.estudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.estudiantes.models.Estudiante;
import com.mar.estudiantes.repositories.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepo;
	
	//todos los estudiantes
	public List<Estudiante> allEstudiantes(){
		return estudianteRepo.findAll();
	}
	
	
	//filtro por region
	public List<Estudiante> filtraPorRegion(Integer region){
		return estudianteRepo.filtroRegion(region);
	}
	
	
	//filtro por curso
	public List<Estudiante> filtraPorCurso(String curso){
		return estudianteRepo.filtroCurso(curso);
	}
	
	
	//filtro por region y curso
	public List<Estudiante> filtraPorRegionCurso(Integer region, String curso){
		return estudianteRepo.filtroRegionCurso(region, curso);
	}
	
	
	//filtros
		public List<Estudiante> filtraTotal(Integer region, String curso){
			
			if (region != 0 && curso.equals("0")) {
				System.out.println("-por region");
				return filtraPorRegion(region);
				
			} else if (region == 0 && !curso.equals("0")) {
				System.out.println("-por curso");
				return filtraPorCurso(curso);
						
			} else if(region != 0 && !curso.equals("0")) {
				System.out.println("-filtro region y curso");
				return filtraPorRegionCurso(region, curso);
						
			} else {
				System.out.println("-sin filtros");
				return allEstudiantes();
			}
		}
}
