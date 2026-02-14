package com.twg.fruitstorerestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twg.fruitstorerestapi.Entity.Cart;
import com.twg.fruitstorerestapi.Entity.Order;
import com.twg.fruitstorerestapi.Entity.OrderItem;
import com.twg.fruitstorerestapi.Repository.CartRepository;
import com.twg.fruitstorerestapi.Repository.OrderItemRepository;
import com.twg.fruitstorerestapi.Repository.OrderRepository;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class OrderController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // ---------------- CHECKOUT API ----------------

    @PostMapping("/checkout/{userId}")
    public String checkout(@PathVariable int userId) {

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            return "Cart is empty!";
        }

        double total = 0;

        for (Cart item : cartItems) {
            total += item.getFruit().getPrice() * item.getQuantity();
        }

        // Save Order
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        // Save Order Items
        for (Cart item : cartItems) {

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setFruitId(item.getFruit().getId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getFruit().getPrice());

            orderItemRepository.save(orderItem);
        }

        // Clear Cart
        cartRepository.deleteAll(cartItems);

        return "Order placed successfully!";
    }
}
