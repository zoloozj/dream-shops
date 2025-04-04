package mn.dailycodework.dreamshops.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.dailycodework.dreamshops.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find images by product ID or other
    // criteria
    List<Image> findByProductId(Long productId);

}
