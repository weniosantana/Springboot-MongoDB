package com.springmongo.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongo.springbootmongodb.domain.User;
import com.springmongo.springbootmongodb.domain.UserDTO;
import com.springmongo.springbootmongodb.repository.UserRepository;
import com.springmongo.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User findByName(String name) {
		User obj = repo.findByName(name);
		if(obj == null) {
			throw new ObjectNotFoundException("Nome não encontrado");
		}
		
		return obj;

	}
	
	public User Insert(User obj) {
		
		return repo.insert(obj);
	}
	
	public void Delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User Update(User obj) {
			User newObj = findById(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
			
		}
	
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	
	
}
