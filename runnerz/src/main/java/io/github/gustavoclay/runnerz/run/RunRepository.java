package io.github.gustavoclay.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

}
