package com.movieuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MovieUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieUserApplication.class, args);
	}

}
