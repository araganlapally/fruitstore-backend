package com.twg.fruitstorerestapi.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    // Default Constructor
    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    // Parameterized Constructor
    public Order(int userId, double totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
    }

    // ---------------- GETTERS ----------------

    public Long getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    // ---------------- SETTERS ----------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}
