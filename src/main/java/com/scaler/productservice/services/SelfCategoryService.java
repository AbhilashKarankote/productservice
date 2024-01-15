package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public boolean isCategoryExists(String categoryName) {
        return categoryRepository.existsByName(categoryName);
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

}
