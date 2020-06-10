package com.clinicaVeterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicaVeterinaria.domain.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer>{

}
