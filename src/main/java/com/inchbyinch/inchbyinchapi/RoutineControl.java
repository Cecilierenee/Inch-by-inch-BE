package com.inchbyinch.inchbyinchapi;


import com.inchbyinch.inchbyinchapi.model.Routine;
import com.inchbyinch.inchbyinchapi.service.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineControl {

    private final RoutineService routineService;

    public RoutineControl(RoutineService routineService) {
        this.routineService = routineService;
    }

    //http:localhost:9193
    @GetMapping("/all")
    public ResponseEntity<List<Routine>> getAllRoutines () {
        List<Routine> routines = routineService.findAllRoutines();
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Routine> getRoutineById (@PathVariable("id") Long id) {
        Routine routines = routineService.findRoutineById(id);
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Routine> addRoutine(@RequestBody Routine routine) {
        Routine newRoutine = routineService.addRoutine(routine);
        return new ResponseEntity<>(newRoutine, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Routine> updateRoutine(@RequestBody Routine routine) {
        Routine updateRoutine = routineService.updateRoutine(routine);
        return new ResponseEntity<>(updateRoutine, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoutineById(@PathVariable("id") Long id) {
        routineService.deleteRoutine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
