package com.kiri.chop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TestingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingListApplication.class, args);
	}

}
