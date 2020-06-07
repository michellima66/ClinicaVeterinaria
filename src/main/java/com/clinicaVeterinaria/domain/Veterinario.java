package com.clinicaVeterinaria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinarios")
public class Veterinario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String CRMV;
	
	@OneToMany(name = "veterinario")
	private List<Consulta> consultas = new ArrayList<>();

	public Veterinario() {
	}

	public Veterinario(Integer id, String nome, String cRMV) {
		super();
		this.id = id;
		this.nome = nome;
		CRMV = cRMV;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCRMV() {
		return CRMV;
	}

	public void setCRMV(String cRMV) {
		CRMV = cRMV;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinario other = (Veterinario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}