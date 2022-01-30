package com.inchbyinch.inchbyinch.security.repository;

import com.inchbyinch.inchbyinch.model.Category;
import com.inchbyinch.inchbyinch.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Routine findByName(String routineName);

    Routine findByNameAndUserId(String name, Long userId);

    List<Routine> findByCategoryId(Long routineId);

    Category findByIdAndUserId(Long categoryId, Long userId);
    
}
