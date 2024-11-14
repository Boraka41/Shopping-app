package com.example.shopping.Repository;

import com.example.shopping.Entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

    Optional<CartItems> findByName(String name);
}
