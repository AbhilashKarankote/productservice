package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    Product createNewProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProducts();
}
