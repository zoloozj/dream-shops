package mn.dailycodework.dreamshops.service.cart;

import java.math.BigDecimal;

import mn.dailycodework.dreamshops.model.Cart;

public interface ICartService {
    Cart getCart(Long id);

    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();

    // Cart getCartByUserId(Long userId);
}
