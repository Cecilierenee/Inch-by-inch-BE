package com.inchbyinch.inchbyinch.service;

import com.inchbyinch.inchbyinch.exceptions.InformationExistException;
import com.inchbyinch.inchbyinch.exceptions.InformationNotFoundException;
import com.inchbyinch.inchbyinch.model.Category;
import com.inchbyinch.inchbyinch.model.Routine;
import com.inchbyinch.inchbyinch.repository.CategoryRepository;
import com.inchbyinch.inchbyinch.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private RoutineRepository routineRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        System.out.println("service calling getCategories");
        return categoryRepository.findAll();
    }

    public Optional getCategory(Long categoryID) {
        System.out.println("service calling getCategory");
        Optional category = categoryRepository.findById(categoryID);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("Category not found");
        }
    }

    public Category createCategory(Category categoryObject) {
        System.out.println("service calling createCategory");

        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("Category with name " + category.getName() + " already exist");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject) {
        System.out.println("service calling updateCategory");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            if (categoryObject.getName().equals(category.get().getName())) {
                System.out.println("same name");
                throw new InformationExistException("category already exist");
            } else {
                Category updateCategory = categoryRepository.findById(categoryId).get();
                updateCategory.setName(categoryObject.getName());
                updateCategory.setDescription(categoryObject.getDescription());
                return categoryRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("category not found");
        }
    }

    public Optional<Category> deleteCategory(Long categoryId) {
        System.out.println("Service calling deleteCategory");
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (((Optional<?>) category).isPresent()) {
            categoryRepository.deleteById(categoryId);
            return category;
        } else {
            throw new InformationNotFoundException("Category not found");
        }
    }

    public Routine createCategoryRoutine(Long categoryId, Routine routineObject) {
        System.out.println("Service calling createCategoryRoutine");
        try {
            Optional category = categoryRepository.findById(categoryId);
            routineObject.setCategory((Category) category.get());
            return routineRepository.save(routineObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("category not found");
        }
    }

    public Routine getCategoryRoutine(Long categoryId, Long routineId) {
        System.out.println("service calling getCategoryRoutine");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Optional<Routine> routine = routineRepository.findByCategoryId(categoryId).stream().filter(
                    p -> p.getId().equals(routineId)).findFirst();
            if (routine.isEmpty()) {
                throw new InformationNotFoundException("Routine not found");
            } else {
                return routine.get();
            }
        } else {
            throw new InformationNotFoundException("Category not fount");
        }

    }

    public List<Routine> getCategoryRoutines(Long categoryId) {
        System.out.println("service calling getCategoryRoutines");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getRoutineList();
        } else {
            throw new InformationNotFoundException("category not found");
        }
    }

    public Routine updateCategoryRoutine(Long categoryId, Long routineId, Routine routineObject) {
        System.out.println("Service calling updateCategoryRoutine");
        try {
            Routine routine = (routineRepository.findByCategoryId(categoryId).stream().filter(p -> p.getId().equals(routineId)).findFirst()).get();
            routine.setProducts(routineObject.getProducts());
            routine.setSteps(routineObject.getSteps());
            return routineRepository.save(routine);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("routine or category not found");
        }
    }

    public void deleteCategoryRoutine(Long categoryId, Long routineId) {
        try {
            Routine routine = (routineRepository.findByCategoryId(categoryId).stream().filter(p -> p.getId().equals(routineId)).findFirst()).get();
            routineRepository.deleteById(routine.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("routine or category not fount");
        }
    }
}
