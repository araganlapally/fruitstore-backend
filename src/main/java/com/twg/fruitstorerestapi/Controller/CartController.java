package com.twg.fruitstorerestapi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twg.fruitstorerestapi.Entity.*;
import com.twg.fruitstorerestapi.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Productrepository productRepository;

    @PostMapping("/cart/{userId}/{fruitId}")
    public Cart addToCart(@PathVariable int userId,
                          @PathVariable long fruitId) {

        User user = userRepository.findById(userId).get();
        Fruits fruit = productRepository.findById(fruitId).get();

        // Check if already exists
        Cart existing = cartRepository
            .findByUserIdAndFruitId(userId, fruitId);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
            return cartRepository.save(existing);
        }

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setFruit(fruit);
        cart.setQuantity(1);

        return cartRepository.save(cart);
    }

    @GetMapping("/cart/{userId}")
    public List<Cart> getUserCart(@PathVariable int userId) {
        return cartRepository.findByUserId(userId);
    }
    @PutMapping("/cart/{cartId}/{quantity}")
    public Cart updateQuantity(@PathVariable Long cartId,
                               @PathVariable int quantity) {

        Cart cart = cartRepository.findById(cartId).get();
        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }
    @DeleteMapping("/cart/{cartId}")
    public void deleteCartItem(@PathVariable Long cartId) {
        cartRepository.deleteById(cartId);
    }


}
