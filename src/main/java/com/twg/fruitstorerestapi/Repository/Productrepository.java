package com.twg.fruitstorerestapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.fruitstorerestapi.Entity.Fruits;

public interface Productrepository extends JpaRepository<Fruits, Long> {
	List<Fruits> findByNameContainingIgnoreCase(String name);


}
