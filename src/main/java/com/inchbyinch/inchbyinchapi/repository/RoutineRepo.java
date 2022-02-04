package com.inchbyinch.inchbyinchapi.repository;

import com.inchbyinch.inchbyinchapi.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoutineRepo extends JpaRepository<Routine, Long> {
    void deleteRoutineById(Long id);

    Optional<Routine> findRoutineById(Long id);
}
