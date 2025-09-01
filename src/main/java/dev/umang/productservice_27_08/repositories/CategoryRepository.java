package dev.umang.productservice_27_08.repositories;

import dev.umang.productservice_27_08.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    /*
    JPA method - behind the scenes, implementation will
    be done by JPA on your behalf
    select * from category where name = 'xyz'
     */
}
