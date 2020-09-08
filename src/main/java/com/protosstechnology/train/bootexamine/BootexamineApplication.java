package com.protosstechnology.train.bootexamine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
//@EnableAdminServer
@SpringBootApplication
public class BootexamineApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootexamineApplication.class, args);

	}

}
