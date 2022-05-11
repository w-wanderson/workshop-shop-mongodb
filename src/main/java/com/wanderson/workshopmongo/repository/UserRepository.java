package com.wanderson.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wanderson.workshopmongo.domain.User;

// Acessar os dados no banco
@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
