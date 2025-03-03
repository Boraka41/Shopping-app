package com.example.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.shopping"})
public class ShoppingApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}
}
