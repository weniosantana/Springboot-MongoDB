package com.springmongo.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springmongo.springbootmongodb.domain.User;
import com.springmongo.springbootmongodb.repository.UserRepository;


@Configuration
public class Instantion implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@gmail.com");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}
	
}
