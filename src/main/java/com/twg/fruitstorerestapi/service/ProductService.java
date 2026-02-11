package com.twg.fruitstorerestapi.service;

import java.util.List;

import com.twg.fruitstorerestapi.Entity.Fruits;

public interface ProductService {
	
	 public Fruits saveFruit(Fruits fruits);
	  public Fruits updateFruit(Fruits fruits);
	  public void deletefruit(Fruits fruits);
	  public Fruits findById(long id);
	  public List <Fruits> findAll();
	  

}
