package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    Product createNewProduct(Product product);

    Product updateProduct(Long id, Product product);

    List<Product> getAllProducts();

    Product deleteProduct(Long id);

    List<Product> getProductsInCategory(String category);
}
