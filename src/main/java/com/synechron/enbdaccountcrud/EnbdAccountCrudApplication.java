package com.synechron.enbdaccountcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EnbdAccountCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnbdAccountCrudApplication.class, args);
	}
}
