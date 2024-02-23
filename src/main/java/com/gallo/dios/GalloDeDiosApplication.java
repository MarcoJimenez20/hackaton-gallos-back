package com.gallo.dios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GalloDeDiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalloDeDiosApplication.class, args);
	}

}
