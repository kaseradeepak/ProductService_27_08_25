package dev.umang.productservice_27_08.dtos;

import dev.umang.productservice_27_08.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}
/*
POST /products
{
    title:
    description:
    image:
    category:
    price:
    token:
}

In your API logic, you will create the actual product
Product p = new Product(); = save in your db as well = add a row in your product table
 */
