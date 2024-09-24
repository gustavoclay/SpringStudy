package io.github.gustavoclay.runnerz;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import io.github.gustavoclay.runnerz.run.Location;
import io.github.gustavoclay.runnerz.run.Run;

@SpringBootApplication
public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// WelcomeMessage welcomeMessage = (WelcomeMessage)
		// context.getBean("welcomeMessage");

		// System.out.println(welcomeMessage);

		log.info("Application started");

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR);
			log.info("RUN: {}", run);
		};
	}

}
