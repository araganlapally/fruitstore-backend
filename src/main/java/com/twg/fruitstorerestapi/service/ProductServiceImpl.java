package com.twg.fruitstorerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.fruitstorerestapi.Repository.Productrepository;
import com.twg.fruitstorerestapi.Entity.Fruits;
import com.twg.fruitstorerestapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private Productrepository productrepository;

	@Override
	public Fruits saveFruit(Fruits fruits) {
		// TODO Auto-generated method stub
		return productrepository.save(fruits);
	}

	@Override
	public Fruits updateFruit(Fruits fruits) {
		// TODO Auto-generated method stub
		return productrepository.save(fruits);
	}

	@Override
	public void deletefruit(Fruits fruits) {
		// TODO Auto-generated method stub
           productrepository.delete(fruits);
	}

	@Override
	public Fruits findById(long id) {
		// TODO Auto-generated method stub
		return productrepository.findById(id).get();
	}

	@Override
	public List<Fruits> findAll() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	

}
