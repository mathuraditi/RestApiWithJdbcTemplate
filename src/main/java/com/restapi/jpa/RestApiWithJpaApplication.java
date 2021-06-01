package com.restapi.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import com.restapi.jpa.dao.StudentRepository;

@SpringBootApplication

@PropertySource("classpath:database.properties")
public class RestApiWithJpaApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(RestApiWithJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(studentRepository.createTable());
		
	}

	
	
	

}
