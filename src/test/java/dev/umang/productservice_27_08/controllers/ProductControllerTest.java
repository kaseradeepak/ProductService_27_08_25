package dev.umang.productservice_27_08.controllers;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    //AAA
    @Test
    void testGetSingleProduct() throws ProductNotFoundException {
        // A -> Arrange
        Long productId = 10L;

        Product expectedProduct = new Product(); // this is the product object that service class is returning.
        when(productService.getSingleProduct(productId))
                .thenReturn(expectedProduct);

        // A -> Act
        //Controller is expected to return the same product object what out service returned.
        Product actualProduct = productController.getSingleProduct(productId);

        // A -> Assert
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testSample() {
        int a = 10;
        int b = 15;

        int actualOutput = a + b;

        //assert actualOutput == 55;
        assertEquals(25, actualOutput, "Expected output is 25, Please check the implementation.");

        //assertNotEquals(a, b);
        //assertThrows()

//        assertTimeout(Duration.ofMillis(1000),
//                () -> productController.getSingleProduct(10L));
    }

}

// Test Case is nothing but a method which tests a particular functionality
// and can get executed automatically.