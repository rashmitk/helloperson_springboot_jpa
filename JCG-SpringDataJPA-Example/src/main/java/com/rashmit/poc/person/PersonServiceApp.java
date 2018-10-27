package com.rashmit.poc.person;

import com.rashmit.poc.person.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonServiceApp	 {

	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	@Autowired
	private PersonService service;

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApp.class, args);
	}
}
