package com.inchbyinch.inchbyinch.service;

import com.inchbyinch.inchbyinch.exceptions.InformationExistException;
import com.inchbyinch.inchbyinch.exceptions.InformationNotFoundException;
import com.inchbyinch.inchbyinch.model.Category;
import com.inchbyinch.inchbyinch.model.Routine;
import com.inchbyinch.inchbyinch.security.repository.CategoryRepository;
import com.inchbyinch.inchbyinch.security.MyUserDetails;
import com.inchbyinch.inchbyinch.security.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    public void setRoutineRepository(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public List<Category> getCategories() {
        System.out.println("service calling getCategories");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        System.out.println(userDetails.getUser().getId());
        List<Category> category = categoryRepository.findByUserId(userDetails.getUser().getId());
        if (category.isEmpty()) {
            throw new InformationNotFoundException("No categories found for user");
        } else {
            return categoryRepository.findAll();
        }
    }

    public Optional getCategory(Long categoryId) {
        System.out.println("service calling getCategory");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Category not found");
        } else {
            return category;
        }
    }

    public Category createCategory(Category categoryObject) {
        System.out.println("service calling createCategory");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByUserIdAndName(userDetails.getUser().getId(), categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("Category with name " + category.getName() + " already exist");
        } else {
            categoryObject.setUser(userDetails.getUser());
            return categoryRepository.save(categoryObject);
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject) {
        System.out.println("service calling updateCategory");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationExistException("category already exist");
        } else {
            category.setName(categoryObject.getName());
            category.setDescription(categoryObject.getDescription());
            return categoryRepository.save(category);
        }
    }

    public String deleteCategory(Long categoryId) {
        System.out.println("Service calling deleteCategory");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Category not found");
        } else {
            categoryRepository.deleteById(categoryId);
            return "category with id" + categoryId + " deleted!";
        }
    }

    public Routine createCategoryRoutine(Long categoryId, Routine routineObject) {
        System.out.println("Service calling createCategoryRoutine");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category not found");
        }
        Routine routine = routineRepository.findByNameAndUserId(routineObject.getName(), userDetails.getUser().getId());
        if (routine != null) {
            throw new InformationExistException("routine with that name already exist")
        }
        routineObject.setUser(userDetails.getUser());
        routineObject.setCategory(category);
        return routineRepository.save(routineObject);
    }

    public List<Routine> getCategoryRoutines(Long categoryId) {
        System.out.println("service calling getCategoryRoutines");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Routine not found");
        }
        return category.getRoutineList();
    }


    public Routine getCategoryRoutine(Long categoryId, Long routineId) {
        System.out.println("service calling getCategoryRoutine");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category not found");

        }
        Optional<Routine> routine = routineRepository.findByCategoryId(categoryId).stream().filter(p -> p.getId().equals(routineId)).findFirst();
        if (!routine.isPresent()) {
            throw new InformationNotFoundException("Routine with that id does not exist");
        }
        return routine.get();
    }

    public Routine updateCategoryRoutine(Long categoryId, Long routineId, Routine routineObject) {
        System.out.println("Service calling updateCategoryRoutine");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("routine or category not found");
        }
        Optional<Routine> routine = routineRepository.findByCategoryId(categoryId).stream().filter(p -> p.getId().equals(routineId)).findFirst();
        if (!routine.isPresent()) {
            throw new InformationNotFoundException("Routine not found");
            Routine oldRoutine = routineRepository.findByNameAndUserIdIsNot(routineObject.getName(), userDetails.getUser().getId(), routineId);
            if (oldRoutine != null) {
                throw new InformationExistException("Routine already exist");
            }
            routine.get().setName(routineObject.getName());
            routine.get().setProducts(routineObject.getProducts());
            routine.get().setSteps(routineObject.getSteps());
        }
        return routineRepository.save(routine.get());
    }


    public void deleteCategoryRoutine(Long categoryId, Long routineId) {
            System.out.println("service calling deleteCategoryRoutine");
            MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            Category category = routineRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
            if (category = null) {
                throw new InformationNotFoundException("routine or category not fount");
            }
            Optional<Routine> routine = routineRepository.findByCategoryId(categoryId).stream().filter(p -> p.getId().equals(routineId)).findFirst();
            if (!routine.isPresent()) {
                throw new InformationNotFoundException("Routine not found");
            }
            routineRepository.deleteById(routine.get().getId());
    }
}
