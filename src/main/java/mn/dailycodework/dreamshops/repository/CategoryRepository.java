package mn.dailycodework.dreamshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.dailycodework.dreamshops.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    boolean existsByName(String name);
}
