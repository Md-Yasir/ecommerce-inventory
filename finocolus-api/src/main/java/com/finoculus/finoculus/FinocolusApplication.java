package com.finoculus.finoculus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.finoculus.finoculus.controller.InventoryController;

@SpringBootApplication
public class FinocolusApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinocolusApplication.class, args);
	}
	
}
