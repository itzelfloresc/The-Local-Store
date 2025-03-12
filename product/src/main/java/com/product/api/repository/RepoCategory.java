package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

@Repository
public interface RepoCategory extends JpaRepository<Category, Integer>{
    @Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
    List<Category> getCategories();
}
