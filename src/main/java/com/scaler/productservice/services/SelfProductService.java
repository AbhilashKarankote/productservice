package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getProductsInCategory(String category) {
        return null;
    }
}
