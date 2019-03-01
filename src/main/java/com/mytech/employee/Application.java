package com.mytech.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.mytech.employee.service.EmplomentService;

@SpringBootApplication
//@EnableDiscoveryClient
public class Application {
	
	//@Autowired
	//EmplomentService emplomentService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
}