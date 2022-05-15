package com.wanderson.workshopmongo.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wanderson.workshopmongo.domain.User;
import com.wanderson.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User wanderson = new User(null, "wanderson santos", "wanderson@hotmail.com");
		User josete = new User(null, "Josete Martinelle", "zeti@gmail.com");
		User cida = new User(null, "Maria Aparecida", "maria@gmail.com");
		
		userRepository.saveAll(Arrays.asList(wanderson,josete,cida));
		
	}

}
