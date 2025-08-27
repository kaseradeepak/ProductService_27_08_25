package dev.umang.productservice_27_08.controllers;

import dev.umang.productservice_27_08.dtos.ProductRequestDTO;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.services.FakestoreProductService;
import dev.umang.productservice_27_08.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    //this is the class which is the entry point of requests

    /*
    Get product details - 1
    Get all products - 2
    Create product - 3
    Update product
    delete product
     */

    @GetMapping("/products/{id}")
    Product getSingleProduct(@PathVariable("id") String id){
        //call the service layer
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    Product createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        /*
        run some validations before calling the service
         */
        return productService.createProduct(
                productRequestDTO.getTitle(),
                productRequestDTO.getDescription(),
                productRequestDTO.getPrice(),
                productRequestDTO.getCategory(),
                productRequestDTO.getImage()
        );
    }
}
