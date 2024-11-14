package com.example.shopping.Controller;

import com.example.shopping.Dto.CartItemsDto;
import com.example.shopping.Entity.CartItems;
import com.example.shopping.Entity.User;
import com.example.shopping.Repository.CartItemsRepository;
import com.example.shopping.Service.CartItemsService;
import com.example.shopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartItemsService cartItemsService;
    @Autowired
    private UserService userService;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @GetMapping("/Cart")
    public ModelAndView viewCart() {
        ModelAndView modelAndView = new ModelAndView("Cart");

        List<CartItems> cartItems = cartItemsService.getAllCartItems();

        for (CartItems item : cartItems) {
            if (item.getQuantity() == null) {
                item.setQuantity(1); // Varsayılan değer olarak 1 atıyoruz
            }
        }

        // Toplam fiyat hesaplama
        int total = cartItems.stream().mapToInt(item -> item.getQuantity() * item.getPrice()).sum();

        modelAndView.addObject("cartItems", cartItems);
        modelAndView.addObject("total", total);

        return modelAndView;
    }

    @PostMapping("/Add-To-Cart")
    public String addToCart(@RequestParam String name, @RequestParam int price, @RequestParam int quantity) {
        // Yeni bir CartItemsDto oluşturuyoruz
        CartItemsDto cartItemsDto = new CartItemsDto();
        cartItemsDto.setName(name);
        cartItemsDto.setPrice(price);
        cartItemsDto.setQuantity(quantity);

        // Sepete ürünü ekliyoruz
        cartItemsService.createCartItems(cartItemsDto);

        // Sepet sayfasına yönlendiriyoruz
        return "redirect:/Cart";
    }

    @GetMapping("/Cart/Delete/{id}")
    public String deleteCartItem(@PathVariable int id) {
        cartItemsService.deleteCartItem(id);
        return "redirect:/Cart"; // Silme işleminden sonra Cart sayfasına yönlendirme
    }
}
