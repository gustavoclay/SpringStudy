package io.github.gustavoclay.vtmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final RestClient restClient;

    public HomeController(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://localhost:8085").build();
    }

    @GetMapping("/block/{seconds}")
    public String home(@PathVariable Integer seconds) {
        // call the blocking application
        ResponseEntity<Void> response = restClient.get()
                .uri("/block/{seconds}", seconds)
                .retrieve()
                .toBodilessEntity();

        log.info("{} on {}", response.getStatusCode(), Thread.currentThread());

        return Thread.currentThread().toString();
    }

}