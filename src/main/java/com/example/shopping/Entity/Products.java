package com.example.shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int price;
    private String name;

    public Products(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

}
