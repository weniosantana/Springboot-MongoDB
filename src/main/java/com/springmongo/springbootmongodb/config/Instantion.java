package com.springmongo.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springmongo.springbootmongodb.domain.AuthorDTO;
import com.springmongo.springbootmongodb.domain.Post;
import com.springmongo.springbootmongodb.domain.User;
import com.springmongo.springbootmongodb.repository.PostRepository;
import com.springmongo.springbootmongodb.repository.UserRepository;


@Configuration
public class Instantion implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@gmail.com");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));;
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPostList().addAll(Arrays.asList(post1, post2));
		
		userRepository.saveAll(Arrays.asList(maria));
		
	}
	
}
