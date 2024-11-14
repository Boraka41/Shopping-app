package com.example.shopping.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int price;
    private String name;
    private Integer quantity;

    public CartItems(int id, int price, String name,Integer quantity) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

}