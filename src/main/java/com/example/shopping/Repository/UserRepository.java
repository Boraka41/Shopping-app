package com.example.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shopping.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
