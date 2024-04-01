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

import com.springmongo.springbootmongodb.domain.Post;
import com.springmongo.springbootmongodb.domain.PostDTO;
import com.springmongo.springbootmongodb.domain.User;
import com.springmongo.springbootmongodb.domain.UserDTO;
import com.springmongo.springbootmongodb.services.PostService;
import com.springmongo.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value="/post")
public class PostResource {

	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll(){

		List<Post> list = service.findAll();
		List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		
		Post list = service.findById(id);
		
		return ResponseEntity.ok().body(new PostDTO(list));

	}
			
	@PostMapping
	public ResponseEntity<Void> Insert(@RequestBody PostDTO objDTO){
		
		Post obj = service.fromDTO(objDTO);
		obj = service.Insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PostDTO> Delete(@PathVariable String id){
		service.Delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PostDTO> Update(@PathVariable String id, @RequestBody PostDTO objDTO){
		
		Post obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.Update(obj);
		
		return ResponseEntity.noContent().build();
 
		
		
	}
	
	
}
