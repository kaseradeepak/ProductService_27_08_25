package dev.umang.productservice_27_08.controllers;

import dev.umang.productservice_27_08.dtos.ProductNotFoundErrorDTO;
import dev.umang.productservice_27_08.dtos.ProductRequestDTO;
import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.services.FakestoreProductService;
import dev.umang.productservice_27_08.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Product> getSingleProduct(@PathVariable("id") String id) throws ProductNotFoundException {
        //call the service layer
        Product product = productService.getSingleProduct(id);

        if(product == null){
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
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
    /*
    We got an exception but we don't want to send the stack trace to the client
        1. We can handle the exception in the controller method itself
        2. We can have a global exception handler using @ControllerAdvice
        3. We can have a local exception handler using @ExceptionHandler
     */

}
