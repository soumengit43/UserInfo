package com.UserDetails.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.UserDetails.demo.model.User;

@SpringBootApplication
@EntityScan("com.UserDetails.demo.model")
public class UserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
		
		User u1;
		
	}

}
