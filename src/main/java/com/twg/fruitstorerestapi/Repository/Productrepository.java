package com.twg.fruitstorerestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.fruitstorerestapi.Entity.Fruits;

public interface Productrepository extends JpaRepository<Fruits, Long> {

}
