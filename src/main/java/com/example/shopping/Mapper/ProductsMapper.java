package com.example.shopping.Mapper;

import com.example.shopping.Dto.ProductsDto;
import com.example.shopping.Entity.Products;

public class ProductsMapper {

    public static Products mapToProducts(ProductsDto productsDto){
        Products products = new Products(
                productsDto.getId(),
                productsDto.getPrice(),
                productsDto.getName()
        );
        return products;
    }

    public static ProductsDto mapToProductsDto(Products products) {
        ProductsDto productsDto = new ProductsDto(
                products.getId(),
                products.getName(),
                products.getPrice()

        );
        return productsDto;
    }
}
