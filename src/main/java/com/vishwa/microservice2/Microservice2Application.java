package com.vishwa.microservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * GET 127.0.0.1:7072/ms2/v1/message
 */
@RestController
@SpringBootApplication
@RequestMapping("/messages")
@EnableDiscoveryClient
public class Microservice2Application {

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

	@GetMapping()
	public ResponseEntity hello(){
		System.out.println("Called the service running on Port "+ serverProperties.getPort() );
		return new ResponseEntity("Hello from Microservice 2",HttpStatus.OK);
	}




}
