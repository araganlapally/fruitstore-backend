package com.twg.fruitstorerestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twg.fruitstorerestapi.Entity.Fruits;
import com.twg.fruitstorerestapi.Entity.Login;
import com.twg.fruitstorerestapi.Entity.User;
import com.twg.fruitstorerestapi.service.ProductService;
import com.twg.fruitstorerestapi.service.UserService;

import jakarta.servlet.http.HttpSession;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class FruitsController {
	@Autowired
	private ProductService productservice;
	@Autowired
	private UserService userService;
	
	@GetMapping("/fruits/")
	public List <Fruits> getallfruits()
	{
		List <Fruits> fruitslist=productservice.findAll();
		
		return fruitslist;
	}
	@GetMapping("/fruits/search")
	public List<Fruits> searchFruits(@RequestParam String name) {
	    return productservice.searchByName(name);
	}

	@GetMapping("/fruits/{id}")
	public Fruits addfruit(@PathVariable long id)
	{
		Fruits fruit=productservice.findById(id);
		return fruit;
		
	}
	@DeleteMapping("/fruits/{id}")
	public void deletefruit(@PathVariable long id)
	{
		Fruits fruit=productservice.findById(id);
		productservice.deletefruit(fruit);
	}
	@PostMapping("/fruits/")
	
		public Fruits addfruit(@RequestBody Fruits fruit)
		{
			Fruits addfruit=productservice.saveFruit(fruit);
			return addfruit;
		}
	@PutMapping("/fruits/")
	public Fruits updatefruit(@RequestBody Fruits fruit)
	{
		Fruits updatefruit=productservice.updateFruit(fruit);
		return updatefruit;
		
	}
	@PutMapping("/fruits/{id}")
	public Fruits upfruit(@RequestBody Fruits fruit,@PathVariable long id)
	{
		Fruits up1fruit=productservice.findById(id);
		up1fruit.setDescription(fruit.getDescription());
		up1fruit.setName(fruit.getName());
		up1fruit.setPrice(fruit.getPrice());
		up1fruit.setImageurl(fruit.getImageurl());
		Fruits updatedfruit=productservice.saveFruit(up1fruit);
		return updatedfruit;
		
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{
		User registeredUser=userService.registerUser(user);
		return  registeredUser;
	}
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable String username){
	    return userService.findByUsername(username);
	}

	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Login loginRequest, HttpSession session) {
	    User user = userService.findByUsername(loginRequest.getUsername());

	    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
	        // Store user in the session
	        session.setAttribute("loggedInUser", user);
	        return ResponseEntity.status(HttpStatus.OK).body("Login successful!");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
	    }
	}


	
	
	
	
	

}
