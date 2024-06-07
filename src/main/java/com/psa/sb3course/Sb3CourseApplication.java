package com.psa.sb3course;

import com.psa.sb3course.run.Location;
import com.psa.sb3course.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Sb3CourseApplication {
    private static final Logger log = LoggerFactory.getLogger(Sb3CourseApplication.class);

    public static void main(String[] args) {
       SpringApplication.run(Sb3CourseApplication.class, args);
       log.info("Application started successfully!");
    }

    @Bean
    CommandLineRunner runner () {
        return args -> {
            Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR);
            log.info("Run: " + run);
        };
    }

}
