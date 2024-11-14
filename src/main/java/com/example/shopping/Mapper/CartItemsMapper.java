package com.example.shopping.Mapper;

import com.example.shopping.Dto.CartItemsDto;
import com.example.shopping.Entity.CartItems;
import com.example.shopping.Entity.Products;

public class CartItemsMapper {
    public static CartItems mapToCartItems(CartItemsDto cartItemsDto) {
        CartItems cartItems = new CartItems(
                cartItemsDto.getId(),
                cartItemsDto.getPrice(),
                cartItemsDto.getName(),
                cartItemsDto.getQuantity()
        );
        return cartItems;
    }
    public static CartItemsDto mapToCartItemsDto(CartItems cartItems){
        CartItemsDto cartItemsDto = new CartItemsDto(
                cartItems.getId(),
                cartItems.getName(),
                cartItems.getPrice(),
                cartItems.getQuantity()

        );
        return cartItemsDto;
    }
}
