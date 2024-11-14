package com.example.shopping.Service;

import com.example.shopping.Entity.CartItems;
import com.example.shopping.Dto.CartItemsDto;
import com.example.shopping.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartItemsService {
    CartItemsDto createCartItems(CartItemsDto cartItemsDto);
    public List<CartItems> getAllCartItems();
    public CartItemsDto getCartItemById(int id);
    void deleteCartItem(int id);

}
