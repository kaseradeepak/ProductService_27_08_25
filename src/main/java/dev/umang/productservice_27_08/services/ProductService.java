package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(String id);
    Product createProduct(String title,
                          String description,
                          double price,
                          String categoryName,
                          String image);

    List<Product> getAllProducts();
}
