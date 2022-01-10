package com.nitinIT;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nitinIT.models.Role;
import com.nitinIT.models.User;
import com.nitinIT.repository.UserRepository;

@SpringBootApplication
public class Application  {

	
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}




}