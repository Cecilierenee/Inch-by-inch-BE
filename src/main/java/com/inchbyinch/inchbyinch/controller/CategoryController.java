package com.inchbyinch.inchbyinch.controller;

import com.inchbyinch.inchbyinch.model.Category;

import com.inchbyinch.inchbyinch.model.Routine;
import com.inchbyinch.inchbyinch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //http://localhost:9192/api/categories/
    @GetMapping(path = "/categories/")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

   //http://localhost:9192/api/categories/{categoryId}
    @GetMapping(path = "/categories/{categoryId}")
    public Optional getCategory(@PathVariable Long categoryId) {
        System.out.println("getting the category with the id of " + categoryId);
        return categoryService.getCategory(categoryId);
    }

    //http://localhost:9192/api/categories/
    @PostMapping("/categories/")
    public Category createCategory(@RequestBody Category categoryObject) {
        System.out.println("creating a category ");
        return categoryService.createCategory(categoryObject);
    }

    //http://localhost:9192/api/categories/{categoryId}
    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
        System.out.println("updating the category");
        return categoryService.updateCategory(categoryId, categoryObject);
    }

    //http://localhost:9192/api/categories/{categoryId}
    @DeleteMapping("/categories/{categoryId}")
    public Optional<Category> deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
        System.out.println("deleting the category with the id of " + categoryId);
        return categoryService.deleteCategory(categoryId);
    }

    //http://localhost:9192/api/categories/{categoryId}/routines
    @PostMapping("/categories/{categoryId}/routines")
    public Routine createCategoryRoutine(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Routine routineObject) {
        System.out.println("Calling createCategoryRoutine");
        return categoryService.createCategoryRoutine(categoryId, routineObject);
    }

    //http://localhost:9192/api/categories/{categoryId}/routines
    @GetMapping("/categories/{categoryId}/routines")
    public List<Routine> getCategoryRoutines(@PathVariable(value = "categoryId") Long categoryId) {
        System.out.println("calling getCategoryRoutines");
        return categoryService.getCategoryRoutines(categoryId);
    }

    //http://localhost:9192/api/categories/{categoryId}/routines/{routineId}
    @GetMapping("/categories/{categoryId}/routines/{routineId}")
    public Routine getCategoryRoutine(@PathVariable(value = "categoryId")Long categoryId,
                                      @PathVariable(value = "routineId") Long routineId) {
        System.out.println("Calling getCategoryRoutine");
        return categoryService.getCategoryRoutine(categoryId, routineId);
    }

    //http://localhost:9192/api/categories/{categoryId}/routines/{routineId}
    @PutMapping("/categories/{categoryId}/routines/{routineId}")
    public Routine updateCategoryRoutine(@PathVariable(value = "categoryId")Long categoryId,
                                        @PathVariable(value = "routineId") Long routineId,
                                        @RequestBody Routine routineObject) {
        System.out.println("Calling updateCategoryRoutine");
        return categoryService.updateCategoryRoutine(categoryId, routineId, routineObject);
    }

    //http://localhost:9192/api/categories/{categoryId}/routines/{routineId}
    @DeleteMapping("/categories/{categoryId}/routines/{routineId}")
    public ResponseEntity<HashMap> deleteCategoryRoutine(@PathVariable(value = "categorId") Long categoryId,
                                                         @PathVariable(value = "routineId") Long routineId) {
        System.out.println("Calling getCategoryRoutine");
        categoryService.deleteCategoryRoutine(categoryId, routineId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "routine with id: " + routineId + " was successfully deleted");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }
}

