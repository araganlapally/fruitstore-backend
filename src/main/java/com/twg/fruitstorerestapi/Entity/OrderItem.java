package com.twg.fruitstorerestapi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "fruit_id", nullable = false)
    private Long fruitId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    // Default Constructor
    public OrderItem() {
    }

    // Parameterized Constructor
    public OrderItem(Long orderId, Long fruitId, int quantity, double price) {
        this.orderId = orderId;
        this.fruitId = fruitId;
        this.quantity = quantity;
        this.price = price;
    }

    // ---------------- GETTERS ----------------

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getFruitId() {
        return fruitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // ---------------- SETTERS ----------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setFruitId(Long fruitId) {
        this.fruitId = fruitId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", fruitId=" + fruitId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
