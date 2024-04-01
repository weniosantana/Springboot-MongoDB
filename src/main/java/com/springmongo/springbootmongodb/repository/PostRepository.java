package com.springmongo.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongo.springbootmongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByBodyContainingIgnoreCase(String text);
}
