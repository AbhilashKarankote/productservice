package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("fakeStoreCategoryService")
public class FakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;

    @Autowired
    FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate =restTemplate;
    }

    @Override
    public List<Category> getAllCategories() {
        String[] categories = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        assert categories != null;
        return Arrays.stream(categories).map(c -> {
            Category category = new Category();
            category.setName(c);
            return category;
        }).toList();
    }

    @Override
    public boolean isCategoryExists(String categoryName) {
        return false;
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return Optional.empty();
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }
}
