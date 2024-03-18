package com.springmongo.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongo.springbootmongodb.domain.Post;
import com.springmongo.springbootmongodb.domain.User;
import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	
}
