package com.mar.estudiantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar.estudiantes.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

}
