package com.stepanew.technicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TechnicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicServiceApplication.class, args);
	}

}
