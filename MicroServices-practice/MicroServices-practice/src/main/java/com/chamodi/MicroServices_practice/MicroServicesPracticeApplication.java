package com.chamodi.MicroServices_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // This application will run as the service registry.
public class MicroServicesPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesPracticeApplication.class, args);
	}

}
