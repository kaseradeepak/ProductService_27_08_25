package dev.umang.productservice_27_08.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

//@Getter
//@Setter
public class ProductRequestDTO {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
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
