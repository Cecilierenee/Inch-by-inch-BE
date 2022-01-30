package com.inchbyinch.inchbyinch.security.repository;

import com.inchbyinch.inchbyinch.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);

    Category findByIdAndUserId(Long categoryId, Long userId);

    Category findByUserIdAndName(Long userId, String name);

    List<Category> findByUserId(Long userId);
}
