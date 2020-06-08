package com.clinicaieterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaVeterinaria.domain.Animal;

@RestController
@RequestMapping("/animais")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<List<Animal>> list(){
		List<Animal> animais = animalService.list();
		
		return ResponseEntity.ok(animais);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> find(@PathVariable Integer id){
		Animal animal = animalService.ok(animal);
		
		return ResponseEntity.ok(animal);
	}
	
}
