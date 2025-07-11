package com.sb21java.springboot21javaApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages="com.sb21java")
@EnableJpaRepositories(basePackages="com.sb21java.repository")
@EntityScan(basePackages="com.sb21java.model")
public class Springboot21javaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot21javaApplication.class, args);
		System.out.println("Project is running!");
	}
	
	@Bean
	public RestTemplate geRestTemplate()
	{
		return new RestTemplate();
	}
}
