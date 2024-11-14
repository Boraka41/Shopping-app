package com.example.shopping.Controller;

import com.example.shopping.Dto.ProductsDto;
import com.example.shopping.Entity.Products;
import com.example.shopping.Service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    private ProductsService productsService;

    public HomeController(ProductsService productsService) {
        this.productsService = productsService;
    }
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MainPage");
        return modelAndView;
    }

    @GetMapping("/Products")
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView("Product");
        List<Products> products = productsService.getAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @PostMapping("/AddProduct")
    public ResponseEntity<ProductsDto> addProduct(@RequestBody ProductsDto productsDto){
        return new ResponseEntity<>(productsService.createProduct(productsDto), HttpStatus.CREATED);
    }
}

