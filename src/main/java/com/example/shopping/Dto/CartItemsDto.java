package com.example.shopping.Dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsDto {
    private int id;
    private String name;
    private int price;
    private Integer quantity;


}
