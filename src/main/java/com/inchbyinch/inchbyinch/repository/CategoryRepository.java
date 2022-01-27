package com.inchbyinch.inchbyinch.repository;

import com.inchbyinch.inchbyinch.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
}
