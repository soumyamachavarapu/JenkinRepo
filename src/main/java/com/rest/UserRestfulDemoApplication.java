package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserRestfulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRestfulDemoApplication.class, args);
	}

}
