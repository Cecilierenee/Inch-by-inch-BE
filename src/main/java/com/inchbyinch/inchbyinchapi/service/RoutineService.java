package com.inchbyinch.inchbyinchapi.service;

import com.inchbyinch.inchbyinchapi.exceptions.RoutineNotFoundException;
import com.inchbyinch.inchbyinchapi.model.Routine;
import com.inchbyinch.inchbyinchapi.repository.RoutineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoutineService {
    private final RoutineRepo routineRepo;

    @Autowired
    public RoutineService(RoutineRepo routineRepo) {
        this.routineRepo = routineRepo;
    }

    public Routine addRoutine(Routine routine) {
        routine.getId();
        return routineRepo.save(routine);
    }

    public List<Routine> findAllRoutines() {
        return routineRepo.findAll();
    }

    public Routine updateRoutine(Routine routine) {
        return routineRepo.save(routine);
    }

    public Routine findRoutineById(Long id) {
        return routineRepo.findRoutineById(id).orElseThrow
                (() -> new RoutineNotFoundException("Routine by id " + id + " was not found"));
    }

    public void deleteRoutine(Long id) {
        routineRepo.deleteRoutineById(id);
    }
}
