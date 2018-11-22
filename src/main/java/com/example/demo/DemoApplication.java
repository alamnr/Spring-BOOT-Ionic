package com.example.demo;

import com.example.demo.domain.Beer;
import com.example.demo.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Resource
	private BeerRepository repository;

	@Bean
	public CommandLineRunner populateBeers(){
		return new BeerPopulatorRunner();
	}

	public class BeerPopulatorRunner implements  CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			repository.save(new Beer("Teddy","Good"));
			repository.save(new Beer("Tony","Bad"));
			repository.save(new Beer("Brew","Great"));
			repository.save(new Beer("Andrew","Good"));
			repository.save(new Beer("Tom","Good"));
		}
	}

}
