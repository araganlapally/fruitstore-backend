package com.twg.fruitstorerestapi.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.twg.fruitstorerestapi.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(int userId);
    Cart findByUserIdAndFruitId(int userId, long fruitId);

}
