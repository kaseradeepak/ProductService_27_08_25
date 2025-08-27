package dev.umang.productservice_27_08;

import dev.umang.productservice_27_08.controllers.ProductController;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.services.FakestoreProductService;
import dev.umang.productservice_27_08.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductService2708Application {

    public static void main(String[] args) {
//        Product product = new Product();
//        product.setId("p1");
//        product.getCategory();

        //ProductService productService = new FakestoreProductService();
        //ProductController productController = new ProductController(productService);

        SpringApplication.run(ProductService2708Application.class, args);
    }

}
