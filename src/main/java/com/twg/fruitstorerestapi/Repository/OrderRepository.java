package com.twg.fruitstorerestapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.fruitstorerestapi.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(int userId);
}

