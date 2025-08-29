package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(String id) throws ProductNotFoundException;
    Product createProduct(String title,
                          String description,
                          double price,
                          String categoryName,
                          String image);

    List<Product> getAllProducts();
}
