package mn.dailycodework.dreamshops.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mn.dailycodework.dreamshops.exceptions.ResourceNotFoundException;
import mn.dailycodework.dreamshops.model.Cart;
import mn.dailycodework.dreamshops.repository.CartRepository;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;
    private final mn.dailycodework.dreamshops.repository.CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart not foundd"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }

    @Override
    public BigDecimal getTotalPrice(Long cartId) {
        Cart cart = getCart(cartId);
        return cart.getTotalAmount();
    }

    @Override
    public void clearCart(Long cartId) {
        Cart cart = getCart(cartId);
        cartItemRepository.deleteAllByCartId(cartId);
        cart.getCartItems().clear();
        cartRepository.deleteById(cartId);
    }
}
