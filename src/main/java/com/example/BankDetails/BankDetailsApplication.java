package com.example.BankDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.example.BankDetails"})
public class BankDetailsApplication {

	public static void main(String[] args) {
		ApplicationContext apxt = SpringApplication.run(BankDetailsApplication.class, args);
	}

}
