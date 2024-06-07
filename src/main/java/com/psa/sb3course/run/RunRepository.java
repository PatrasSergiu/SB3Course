package com.psa.sb3course.run;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }
    Optional<Run> findById(Integer id) {
        return runs.stream().
                filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }
    void create(Run run) {
        runs.add(run);
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Run inside",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                2,
                Location.INDOOR));

        runs.add(new Run(2,
                "Run outside",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                4,
                Location.OUTDOOR));
    }
}
