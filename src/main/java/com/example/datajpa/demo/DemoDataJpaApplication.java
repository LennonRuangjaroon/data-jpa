package com.example.datajpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDataJpaApplication.class, args);
	}
}
