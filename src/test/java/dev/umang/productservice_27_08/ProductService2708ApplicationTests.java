package dev.umang.productservice_27_08;

import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.repositories.CategoryRepository;
import dev.umang.productservice_27_08.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductService2708ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    public void testFetchTypes() {
////        Optional<Product> optionalProduct = productRepository.findById(1L);
//
//        Optional<Category> categoryOptional = categoryRepository.findById(1L);
//
//        //Category category = categoryOptional.get();
//
////        List<Product> products = category.getProducts();
////
////        for (Product product : products) {
////            System.out.println(product.getTitle());
////        }
//
//        System.out.println("DEBUG");
//    }

}
