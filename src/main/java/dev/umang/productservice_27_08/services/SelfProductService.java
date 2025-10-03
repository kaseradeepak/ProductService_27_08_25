package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;
import dev.umang.productservice_27_08.repositories.CategoryRepository;
import dev.umang.productservice_27_08.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return optionalProduct.get();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 Category category,
                                 String image) {
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage(image);

        //first we should save the category
        if (category.getId() != null) {
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());

            if (categoryOptional.isEmpty()) {
                //throw InvalidCategoryException or create the category.
            }

            p.setCategory(categoryOptional.get());
        } else {
            Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());

            if (categoryOptional.isPresent()) {
                p.setCategory(categoryOptional.get());
            } else {
                Category c = new Category();
                c.setName(category.getName());
                c = categoryRepository.save(c);

                p.setCategory(c);
            }
        }

        return productRepository.save(p);

//        /*
//        1. This categoryName already exists in the db
//        Fetch the category from the db
//        2. This categoryName does not exist in the db
//        Create a new category with this name in the db
//         */
//        Category category = categoryRepository.findByName(categoryName);
//        if(category == null) {
//            //category does not exist
//            Category newCategory = new Category();
//            newCategory.setName(categoryName);
//            Category savedCategory = categoryRepository.save(newCategory);
//            p.setCategory(savedCategory);
//        }else{
//            //category exists
//            p.setCategory(category);
//        }
//        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {

        /*
        Page Size = 10
        Page Number = 7

        Limit = 10
        Offset = 61 (10 * 6 + 1)
         */

        Sort sort = Sort.by(Sort.Direction.ASC, "price")
                .and(Sort.by(Sort.Direction.ASC, "title"))
                .and(Sort.by(Sort.Direction.ASC, "id"));

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        return productRepository.findByTitleContainsIgnoreCase(title,  pageRequest);
    }
}


// Git fork