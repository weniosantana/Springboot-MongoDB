package com.springmongo.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongo.springbootmongodb.domain.Post;
import com.springmongo.springbootmongodb.domain.PostDTO;
import com.springmongo.springbootmongodb.repository.PostRepository;
import com.springmongo.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
		
	public Post Insert(Post obj) {
		
		return repo.insert(obj);
	}
	
	public void Delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Post Update(Post obj) {
			Post newObj = findById(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
			
		}
	
	public void updateData(Post newObj, Post obj) {
		newObj.setDate(obj.getDate());
		newObj.setTitle(obj.getTitle());
		newObj.setBody(obj.getBody());
		newObj.setAuthor(obj.getAuthor());
	}
	
	public Post fromDTO(PostDTO objDTO) {
		return new Post(objDTO.getId(), objDTO.getDate(), objDTO.getTitle(), objDTO.getBody(), null);
	}
	
	
	
}
