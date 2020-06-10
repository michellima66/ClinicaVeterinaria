package com.clinicaVeterinaria.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clinicaVeterinaria.domain.Animal;
import com.clinicaVeterinaria.domain.Cliente;
import com.clinicaVeterinaria.domain.Consulta;
import com.clinicaVeterinaria.domain.Especie;
import com.clinicaVeterinaria.domain.Veterinario;
import com.clinicaVeterinaria.domain.enums.TipoSexo;
import com.clinicaVeterinaria.repository.AnimalRepository;
import com.clinicaVeterinaria.repository.ClienteRepository;
import com.clinicaVeterinaria.repository.ConsultaRepository;
import com.clinicaVeterinaria.repository.EspecieRepository;
import com.clinicaVeterinaria.repository.VeterinarioRepository;
import com.clinicaVeterinaria.util.DataHora;

@SpringBootApplication
public class ClinicaVeterinariaTeste implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaTeste.class, args);
		
		System.out.println("Hello World com Spring Boot!");
	}

	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Especie esp1 = new Especie(null, "Felino");
		Especie esp2 = new Especie(null, "Canino");
		Especie esp3 = new Especie(null, "Ave");
		
		especieRepository.saveAll(Arrays.asList(esp1,esp2,esp3));

		Cliente c1 = new Cliente(null, "Marcos", "Rua das Acacias, Fortaleza, 349", "0859823453", "marcos@hotmail.com");
		Cliente c2 = new Cliente(null, "Morgana", "Rua Macilio Dias, Jacarecanga, 3876", "085987569983", "morgana@hotmail.com");
		Cliente c3 = new Cliente(null, "Rafael", "Rua Monsenhor Rosa, Maracanaú, 79", "085987939225", "rafael@hotmail.com");

		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Animal a1 = new Animal(null, "Xanny", 3, TipoSexo.MACHO, esp1, c3);
		Animal a2 = new Animal(null, "Jade", 2, TipoSexo.FEMEA, esp2, c2);
		Animal a3 = new Animal(null, "Pretinha", 5, TipoSexo.FEMEA, esp2, c2);
		Animal a4 = new Animal(null, "Junior", 3, TipoSexo.MACHO, esp3, c1);
		
		c1.getPets().addAll(Arrays.asList(a1,a2));
		c2.getPets().addAll(Arrays.asList(a3,a4));
		c3.getPets().addAll(Arrays.asList(a3,a4));
		
		animalRepository.saveAll(Arrays.asList(a1,a2,a3,a4));

		esp1.getAnimais().addAll(Arrays.asList(a1,a2));
		esp2.getAnimais().addAll(Arrays.asList(a3,a4));
		
		Veterinario vet1 = new Veterinario(null, "Dr. Carmona", "983074-78");
		Veterinario vet2 = new Veterinario(null, "Dr. Tamires", "981223-99");
		Veterinario vet3 = new Veterinario(null, "Dr. Jannier", "645389-57");
		
		veterinarioRepository.saveAll(Arrays.asList(vet1,vet2,vet3));
		
		new DataHora();
		Consulta con1 = new Consulta(null, DataHora.converteDataHora("07/01/2020 13:50"), "Av. Francisco Sá, 3679, Jacarecanga", "Vacina anti-rabica", a2, vet1);
		Consulta con2 = new Consulta(null, DataHora.converteDataHora("12/02/2020 13:30"), "Av. Francisco Sá, 3679, Jacarecanga", "Raio-X da pata", a1, vet1);
		Consulta con3 = new Consulta(null, DataHora.converteDataHora("17/05/2020 15:00"), "Av. Francisco Sá, 3679, Jacarecanga", "Exame de rotina", a4, vet2);
		Consulta con4 = new Consulta(null, DataHora.converteDataHora("28/09/2020 08:25"), "Av. Francisco Sá, 3679, Jacarecanga", "Vacina anti-rabica", a3, vet3);
		
		consultaRepository.saveAll(Arrays.asList(con1,con2,con3,con4));
		
		a1.getHistorico().add(con1);
		a2.getHistorico().add(con2);
		a3.getHistorico().add(con3);
		a4.getHistorico().add(con4);
		
		vet1.getConsultas().add(con1);
		vet2.getConsultas().addAll(Arrays.asList(con2,con3));
		vet3.getConsultas().add(con4);
	}

}
