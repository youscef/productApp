package com.example.productapp.service;

import com.example.productapp.model.Product;
import com.example.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(String id) {
        productRepository.delete(findProductById(id));


    }

    public Product updateProduct(String id,Product product) {
        Product existinProduct = findProductById(id);
        existinProduct.setName(product.getName());
        existinProduct.setPrice(product.getPrice());
        return productRepository.save(existinProduct);
    }
}
