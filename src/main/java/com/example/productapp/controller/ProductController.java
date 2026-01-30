package com.example.productapp.controller;

import com.example.productapp.model.Product;
import com.example.productapp.repository.ProductRepository;
import com.example.productapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{product_id}")
    public Product findProductById(@PathVariable("product_id") String id) {
        return productService.findProductById(id);
    }

    @GetMapping()
    public List<Product> findAllProduct() {
        return productService.findAll();
    }

    @PutMapping("/{product_id}")
    public Product updateProduct(@PathVariable String id, @RequestBody() Product product) {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{product_id}")
    public void deleteProduct(@PathVariable("product_id") String id) {
        productService.delete(id);
    }
}
