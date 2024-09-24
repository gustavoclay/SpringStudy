package io.github.gustavoclay.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR));
        runs.add(new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR));
        runs.add(new Run(3, "Run 3", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR));
        runs.add(new Run(4, "Run 4", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR));
        runs.add(new Run(5, "Run 5", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR));
    }

    List<Run> findAll() {
        return runs;
    }

    Run findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst()
                .get();

    }
}
