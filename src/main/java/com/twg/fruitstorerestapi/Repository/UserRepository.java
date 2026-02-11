package com.twg.fruitstorerestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.twg.fruitstorerestapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from users where username=:username LIMIT 1", nativeQuery = true)
	public User findByUsername(String username);

}
