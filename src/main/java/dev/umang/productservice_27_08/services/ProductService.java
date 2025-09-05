package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    Product createProduct(String title,
                          String description,
                          double price,
                          Category category,
                          String image);

    List<Product> getAllProducts();
}
