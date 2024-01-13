package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }



}
