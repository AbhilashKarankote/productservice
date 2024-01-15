package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    private CategoryService categoryService;

    @Autowired
    public SelfProductService(ProductRepository productRepository,@Qualifier("selfCategoryService") CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: "+id+" doesn't exist");
        } else {
            return productOptional.get();
        }
    }

    @Override
    public Product createNewProduct(Product product) {
        String categoryName = product.getCategory().getName();
        Optional<Category> categoryOptional = categoryService.getCategoryByName(categoryName);
        if(categoryOptional.isPresent()){
            product.setCategory(categoryOptional.get());
        } else {
            product.setCategory(categoryService.createCategory(product.getCategory()));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            return createNewProduct(product);
        } else {
            Product dbProduct = productOptional.get();
            if(product.getIsDeleted() != null)dbProduct.setIsDeleted(product.getIsDeleted());
            if(product.getPrice() != null)dbProduct.setPrice(product.getPrice());
            if(product.getTitle() != null)dbProduct.setTitle(product.getTitle());
            if(product.getDescription() != null)dbProduct.setDescription(product.getDescription());
            if(product.getImageUrl() != null)dbProduct.setImageUrl(product.getImageUrl());
            if(product.getCategory() != null && product.getCategory().getName() != null)
                dbProduct.getCategory().setName(product.getCategory().getName());
           return createNewProduct(dbProduct);
        }

    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product deleteProduct(Long id) {
        return productRepository.deleteProductById(id).get();
    }

    @Override
    public List<Product> getProductsInCategory(String category) {
        return productRepository.getProductsByCategory_Name(category);
    }
}
