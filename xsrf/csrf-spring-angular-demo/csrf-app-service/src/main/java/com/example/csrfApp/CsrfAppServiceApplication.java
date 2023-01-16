package com.example.csrfApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CsrfAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrfAppServiceApplication.class, args);
	}




}
