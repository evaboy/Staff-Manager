package com.chibuokem.test.StaffManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages= {"com.chibuokem.test.*"})
@EntityScan("com.chibuokem.test.model")
@EnableJpaRepositories("com.chibuokem.test.repository")
public class StaffManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagerApplication.class, args);
	}

}
