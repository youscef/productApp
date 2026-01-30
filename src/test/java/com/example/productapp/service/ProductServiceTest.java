package com.example.productapp.service;

import com.example.productapp.model.Product;
import com.example.productapp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setup() {
        product = new Product("1", "laptop", 100.00);
    }

    @Test
    public void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        Product created = productService.createProduct(product);

        assertNotNull(created.getId());
        assertEquals("laptop", created.getName());
        assertEquals(100.00, created.getPrice());
    }

    @Test
    public void testFindProductById() {
        when(productRepository.findById("1")).thenReturn(Optional.of(product));

        Product found= productService.findProductById("1");

        assertEquals("1", found.getId());
        assertEquals("laptop", found.getName());
        assertEquals(100.00, found.getPrice());
    }


}
