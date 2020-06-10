package com.clinicaVeterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicaVeterinaria.domain.Especie;
import com.clinicaVeterinaria.repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> list() {
		return especieRepository.findAll();
	}
	
	public Especie find(Integer id) {
		return especieRepository.findById(id).get();
	}
}
