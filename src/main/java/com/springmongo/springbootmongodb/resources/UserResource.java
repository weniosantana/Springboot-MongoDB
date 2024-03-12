package com.springmongo.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springmongo.springbootmongodb.domain.User;
import com.springmongo.springbootmongodb.domain.UserDTO;
import com.springmongo.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){

		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User list = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(list));

	}
	
	@GetMapping(value = "/a/{name}")
	public ResponseEntity<UserDTO> findByName(@PathVariable String name){
		
		User list = service.findByName(name);
		
		return ResponseEntity.ok().body(new UserDTO(list));

	}
	
	@PostMapping
	public ResponseEntity<Void> Insert(@RequestBody UserDTO objDTO){
		
		User obj = service.fromDTO(objDTO);
		obj = service.Insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> Delete(@PathVariable String id){
		service.Delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> Update(@PathVariable String id, @RequestBody UserDTO objDTO){
		
		User obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.Update(obj);
		
		return ResponseEntity.noContent().build();
 
		
		
	}
	
	
}
