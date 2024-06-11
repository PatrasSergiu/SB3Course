package com.psa.sb3course.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    List<Run> findAllByLocation(String location);
    @Query("UPDATE Run r SET r.title = :run.title WHERE r.id = :run.id")
    int update(Run run);
}