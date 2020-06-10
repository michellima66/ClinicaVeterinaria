package com.clinicaVeterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicaVeterinaria.domain.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer>{

}
