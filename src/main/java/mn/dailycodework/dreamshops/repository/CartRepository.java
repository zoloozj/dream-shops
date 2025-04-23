package mn.dailycodework.dreamshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.dailycodework.dreamshops.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Cart findByUserId(Long userId);
}
