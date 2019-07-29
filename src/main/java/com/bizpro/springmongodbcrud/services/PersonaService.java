package com.bizpro.springmongodbcrud.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.bizpro.springmongodbcrud.model.Persona;

public interface PersonaService {
	
	public void crearPersona(List<Persona> persona);
	public Collection<Persona> getPersonas();
	public Optional<Persona> findPersonById(String id);
	
	public void deletePersonaById(String id);
	public void updatePersona(Persona persona);
	public void deletePersona();
	
}
