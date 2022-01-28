package com.inchbyinch.inchbyinch.repository;

import com.inchbyinch.inchbyinch.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Routine findByName(String routineName);

    Routine findByNameAndIdIsNot(String routineName, Long routineId);

    List<Routine> findByCategoryId(Long routineId);
}
