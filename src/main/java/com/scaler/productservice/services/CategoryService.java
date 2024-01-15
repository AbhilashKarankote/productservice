package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    boolean isCategoryExists(String categoryName);

    Optional<Category> getCategoryByName(String categoryName);

    Category createCategory(Category category);
}
