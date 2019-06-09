package dev.codethat.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "dev.codethat.retail")
public class MyRetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailServiceApplication.class, args);
	}

}
