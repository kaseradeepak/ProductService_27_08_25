package dev.umang.productservice_27_08.controllers;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
//    //AAA
//    @Test
//    void testGetSingleProduct() throws ProductNotFoundException {
//        // A -> Arrange
////        Long productId = 2L;
////
////        // @17632
////        Product expectedProduct = new Product(); // this is the product object that service class is returning.
////        expectedProduct.setId(productId);
////
////        String expectedTitle = "iPhone 17 pro"; // @1245
////        expectedProduct.setTitle(expectedTitle);
////
////        String expectedDescription = "iPhone 17 pro"; // @1675
////        expectedProduct.setDescription(expectedDescription);
////        expectedProduct.setPrice(140000);
////
////        when(productService.getSingleProduct(productId))
////                .thenReturn(expectedProduct);
//
//        // A -> Act
//        //Controller is expected to return the same product object what out service returned.
//        // @17632
////        Product actualProduct = productController.getSingleProduct(productId);
////
////        // A -> Assert
////        assertEquals(expectedProduct, actualProduct);
////
////        assertEquals(expectedTitle, actualProduct.getTitle());
////
////        assertEquals(expectedDescription, actualProduct.getDescription());
//    }
//
//    @Test
//    void testSample() {
//        int a = 10;
//        int b = 15;
//
//        int actualOutput = a + b;
//
//        //assert actualOutput == 55;
//        assertEquals(25, actualOutput, "Expected output is 25, Please check the implementation.");
//
//        //assertNotEquals(a, b);
//        //assertThrows()
//
////        assertTimeout(Duration.ofMillis(1000),
////                () -> productController.getSingleProduct(10L));
//    }
//
////    @Test
////    void testGetAllProducts() {
////
////
////
////    }
//
//    @Test
//    void testGetSingleProductWithProductNotFoundException() throws ProductNotFoundException {
////        Long productId = -1L;
////
////        when(productService.getSingleProduct(productId))
////                .thenThrow(ProductNotFoundException.class);
////
////        assertThrows(
////                RuntimeException.class,
////                () -> productController.getSingleProduct(productId)
////        );
//    }
//
//    @Test
//    void testGetAllProducts() {
////        List<Product> expectedProducts = new ArrayList<>(); // @17787
////        Product p1 = new Product();
////        Product p2 = new Product();
////        Product p3 = new Product();
////
////        expectedProducts.add(p1);
////        expectedProducts.add(p2);
////        expectedProducts.add(p3);
////
////        when(productService.getAllProducts())
////                .thenReturn(expectedProducts);
////
////        List<Product> actualProducts = productController.getAllProducts();
////
////        assertEquals(expectedProducts, actualProducts);
//    }
}

// Test Case is nothing but a method which tests a particular functionality
// and can get executed automatically.