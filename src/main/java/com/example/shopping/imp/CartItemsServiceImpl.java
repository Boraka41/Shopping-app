package com.example.shopping.imp;

import com.example.shopping.Dto.CartItemsDto;
import com.example.shopping.Entity.CartItems;
import com.example.shopping.Mapper.CartItemsMapper;
import com.example.shopping.Repository.CartItemsRepository;
import com.example.shopping.Service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    private final CartItemsRepository cartItemsRepository;

    @Autowired
    public CartItemsServiceImpl(CartItemsRepository cartItemsRepository) {
        this.cartItemsRepository = cartItemsRepository;
    }


    @Override
    public CartItemsDto createCartItems(CartItemsDto cartItemsDto) {
        // Sepette aynı isimde ürün var mı kontrol et
        Optional<CartItems> existingCartItem = cartItemsRepository.findByName(cartItemsDto.getName());

        if (existingCartItem.isPresent()) {
            // Ürün zaten varsa, miktarı güncelle
            CartItems cartItems = existingCartItem.get(); 
            cartItems.setQuantity(cartItems.getQuantity() + cartItemsDto.getQuantity());
            CartItems updatedCartItems = cartItemsRepository.save(cartItems);
            return CartItemsMapper.mapToCartItemsDto(updatedCartItems);
        } else {
            // Ürün yoksa, yeni bir ürün ekle
            CartItems cartItems = CartItemsMapper.mapToCartItems(cartItemsDto);
            CartItems savedCartItems = cartItemsRepository.save(cartItems);
            return CartItemsMapper.mapToCartItemsDto(savedCartItems);
        }
    }

    @Override
    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }

    @Override
    public CartItemsDto getCartItemById(int id) {
        Optional<CartItems> cartItems = cartItemsRepository.findById(id);
        if (cartItems.isPresent()) {
            CartItems item = cartItems.get();
            return new CartItemsDto(item.getId(), item.getName(), item.getPrice(),item.getQuantity());
        } else {
            // Handle item not found scenario, possibly throw an exception
            return null;
        }
    }
    @Override
    public void deleteCartItem(int id) {
        cartItemsRepository.deleteById(id);
    }
}