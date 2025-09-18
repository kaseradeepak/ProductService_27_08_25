package dev.umang.productservice_27_08.repositories;

import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //select * from products where id = id
    @Override
    Optional<Product> findById(Long id);

    // select * from products where title = title
    Optional<Product> findByTitle(String title);

    @Override
    List<Product> findAllById(Iterable<Long> longs);

    //select * from products where title like '%iphone%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    //select * from products where title like '%iphone%' LIMIT 10
    //List<Product> findByTitleContainsIgnoreCaseTop10(String title);

    //select * from products where title like '%...%' and description like '%....%'
    List<Product> findByTitleContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String title, String description);

    //JOIN
    //select id from categories where name = name;
    //select * from products where category_id = id;
    List<Product> findByCategory_Name(String name);

    List<Product> findByCategory(Category category);

//    @Query("select * from products p join categories c on p.category_id = c.id where c.name = "mobile" " )
//    List<Product> customQuery();

    @Override
    void deleteById(Long id);
}
