package com.bizpro.springmongodbcrud.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizpro.springmongodbcrud.model.Persona;
import com.bizpro.springmongodbcrud.services.PersonaService;



@RestController
//@RequestMapping(value="/api")
public class PersonaController {
	
	@Autowired
	PersonaService serv;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@PostMapping(value="/createPersona")
	public String create(@RequestBody List<Persona> persona) {
		logger.debug("********** Salvando persona");
		serv.crearPersona(persona);
		return "Se creo Usuario exitosamente...";
	}
	
	@GetMapping(value="/getPersonas")
	public Collection<Persona> getPersonas(){
		logger.debug("******** Obteniendo Personas");
		return serv.getPersonas();
	}
	
	@GetMapping(value= "/getbyid/{id}")
	public Optional<Persona> getById(@PathVariable(value = "id") String id){
		logger.debug("obteniedo id de persona = {}.", id);
		return serv.findPersonById(id);
	}
	
	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable(value="id") String id, @RequestBody Persona persona) {
		logger.debug("actualizando a la persona con el id= {}", id);
		persona.setId(id);
		serv.updatePersona(persona);
		return "Persona con el Id= " + id + "actualizada";		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") String id) {
		logger.debug("Eliminando persona con el Id= {}", id);
		serv.deletePersonaById(id);
		return "Persona con el id= "+ id + "eliminado";
	}
	
	
	
}
