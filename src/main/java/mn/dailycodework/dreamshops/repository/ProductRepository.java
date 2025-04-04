package mn.dailycodework.dreamshops.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.dailycodework.dreamshops.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String category);

    List<Product> findByBrandName(String brand);

    List<Product> findByCategoryNameAndBrandName(String category, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandNameAndName(String brand, String name);

    Long countByBrandNameAndName(String brand, String name);

}
