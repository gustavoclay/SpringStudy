package io.github.gustavoclay.runnerz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import io.github.gustavoclay.runnerz.user.User;
import io.github.gustavoclay.runnerz.user.UserHttpClient;
import io.github.gustavoclay.runnerz.user.UserRestClient;

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
    UserHttpClient userHttpClient() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(UserHttpClient.class);
    }

    @Bean
    CommandLineRunner runner(UserRestClient userRestClient) {
        return args -> {
            // Run run = new Run(1, "Run 1", LocalDateTime.now(),
            // LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR);
            // log.info("RUN: {}", run);

            // List<User> users = userRestClient.findAll();
            // System.out.println("Users: " + users);

            // User user = userRestClient.findById(1);
            // System.out.println("User: " + user);

            List<User> users = userHttpClient().findAll();
            System.out.println("Users: " + users);

        };
    }

}
