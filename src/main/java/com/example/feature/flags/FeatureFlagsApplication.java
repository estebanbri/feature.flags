package com.example.feature.flags;

import com.example.feature.flags.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FeatureFlagsApplication {

	@Autowired
	private QuoteService quoteService;

	public static void main(String[] args) {
		SpringApplication.run(FeatureFlagsApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (event) -> {
			quoteService.runQuote();
		};
	}

}
