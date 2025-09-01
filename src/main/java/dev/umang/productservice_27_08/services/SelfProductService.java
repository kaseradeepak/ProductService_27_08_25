package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.repositories.CategoryRepository;
import dev.umang.productservice_27_08.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfproductservice")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String categoryName,
                                 String image) {
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage(image);
        /*
        1. This categoryName already exists in the db
        Fetch the category from the db
        2. This categoryName does not exist in the db
        Create a new category with this name in the db
         */
        Category category = categoryRepository.findByName(categoryName);
        if(category == null) {
            //category does not exist
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            Category savedCategory = categoryRepository.save(newCategory);
            p.setCategory(savedCategory);
        }else{
            //category exists
            p.setCategory(category);
        }
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
