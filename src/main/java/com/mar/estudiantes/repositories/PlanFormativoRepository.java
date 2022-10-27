package com.mar.estudiantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar.estudiantes.models.PlanFormativo;

@Repository
public interface PlanFormativoRepository extends JpaRepository<PlanFormativo, String>{

}
