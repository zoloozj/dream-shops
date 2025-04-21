package mn.dailycodework.dreamshops.service.cart;

import mn.dailycodework.dreamshops.model.CartItem;

public interface ICartItemService {
    void addCartItemtoCart(Long cartId, Long productId, int quantity);

    void removeItemFromCart(Long cartId, Long productId);

    void updateItemQuanitity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}
