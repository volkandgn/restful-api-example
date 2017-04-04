package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.user.model.User;
import com.example.user.model.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User();
		user.setName("volkan");
		user.setLastname("dogan");
		userRepository.save(user);
	}

}

