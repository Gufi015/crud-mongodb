package com.bizpro.springmongodbcrud.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bizpro.springmongodbcrud.model.Persona;

@Repository
public interface Personadao extends MongoRepository<Persona, String> {

}
