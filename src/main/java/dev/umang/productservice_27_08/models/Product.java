package dev.umang.productservice_27_08.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private String image;
}

/*
Cardinality
Product Category => M : 1
Product belongs to one Category
Category can have multiple Products
 */

/*

1:1 -> id of one side on other side.
1:M -> id of one side on many side.
M:1 -> id of one side on many side.
M:M -> Mapping table.

 */
