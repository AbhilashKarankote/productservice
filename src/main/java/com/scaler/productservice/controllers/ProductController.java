package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/id")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        Product product = productService.deleteProduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsInCategory(@PathVariable("category") String category){
        List<Product> productsInCategory = productService.getProductsInCategory(category);
        return new ResponseEntity<>(productsInCategory,HttpStatus.OK);
    }
}
