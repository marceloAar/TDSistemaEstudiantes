package com.mar.estudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mar.estudiantes.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
	@Query(value = "SELECT * FROM estudiante JOIN comuna ON comuna.codigo_comuna = estudiante.codigo_comuna JOIN region ON region.codigo_region = comuna.codigo_region WHERE region.codigo_region = ?1", nativeQuery = true)
	List<Estudiante> filtroRegion(Integer region);

	@Query(value = "SELECT * FROM estudiante JOIN curso ON curso.codigo_curso = estudiante.codigo_curso JOIN plan_formativo ON plan_formativo.codigo_plan_formativo = curso.codigo_plan_formativo WHERE plan_formativo.codigo_plan_formativo = ?1", nativeQuery = true)
	List<Estudiante> filtroCurso(String curso);
	
	@Query(value = "SELECT * FROM estudiante JOIN comuna ON comuna.codigo_comuna = estudiante.codigo_comuna JOIN region ON region.codigo_region = comuna.codigo_region JOIN curso ON curso.codigo_curso = estudiante.codigo_curso JOIN plan_formativo ON plan_formativo.codigo_plan_formativo = curso.codigo_plan_formativo WHERE region.codigo_region = ?1 AND plan_formativo.codigo_plan_formativo = ?2", nativeQuery = true)
	List<Estudiante> filtroRegionCurso(Integer region, String curso);
}
