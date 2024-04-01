package com.springmongo.springbootmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmongo.springbootmongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	//Alternativa
	@Query("{ 'title': { $regex: ?0, $options: 'i' }}")
	List<Post> searchTitle(String text);
	
	List<Post> findByBodyContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1}}, { }, { } ]}")
	List<Post> searchAll(String text, Date minDate, Date maxDate);
	
}


