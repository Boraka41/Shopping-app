package com.example.shopping.Service;

import com.example.shopping.Dto.ProductsDto;
import com.example.shopping.Entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    ProductsDto createProduct(ProductsDto productsDto);
    public List<Products> getAllProducts();
    public ProductsDto findProductById(int productId);
}
