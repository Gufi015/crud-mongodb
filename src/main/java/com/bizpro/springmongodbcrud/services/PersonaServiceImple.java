package com.bizpro.springmongodbcrud.services;

import java.util.List;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizpro.springmongodbcrud.dao.Personadao;
import com.bizpro.springmongodbcrud.model.Persona;


@Service
public class PersonaServiceImple implements PersonaService {
	@Autowired
	Personadao dao;
	
	
	@Override
	public void crearPersona(List<Persona> persona) {
		dao.saveAll(persona);
	}
	
	@Override
	public Collection<Persona> getPersonas(){
		return dao.findAll();
	}
	
	@Override
	public Optional<Persona> findPersonById(String id){
		return dao.findById(id);
	}
	
	@Override
	public void deletePersonaById(String id) {
		dao.deleteById(id);
	}
	
	@Override
	public void updatePersona(Persona persona) {
		dao.save(persona);
	}
	
	@Override
	public void deletePersona() {
		dao.deleteAll();
	}
}
