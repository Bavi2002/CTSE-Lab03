package com.sliit.product_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.product_service.model.Product;
import com.sliit.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // POST
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // GET ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
