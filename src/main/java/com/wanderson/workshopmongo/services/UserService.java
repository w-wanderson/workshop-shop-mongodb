package com.wanderson.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderson.workshopmongo.domain.User;
import com.wanderson.workshopmongo.dto.UserDto;
import com.wanderson.workshopmongo.repository.UserRepository;
import com.wanderson.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findByid(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.delete(findByid(id));
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).get();
		updateData(newObj,obj);
		return repo.save(newObj);
		
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
