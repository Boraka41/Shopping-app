package com.example.shopping.imp;

import com.example.shopping.Dto.ProductsDto;
import com.example.shopping.Entity.Products;
import com.example.shopping.Mapper.ProductsMapper;
import com.example.shopping.Repository.ProductsRepository;
import com.example.shopping.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public ProductsDto createProduct(ProductsDto productsDto) {
        Products products = ProductsMapper.mapToProducts(productsDto);
        Products savedProducts = productsRepository.save(products);
        return ProductsMapper.mapToProductsDto(savedProducts);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public ProductsDto findProductById(int productId) {
        // Veritabanından productId ile ürünü bul
        Optional<Products> productOpt = productsRepository.findById(productId);

        Products product = productOpt.get();

        // Products nesnesini ProductsDto nesnesine dönüştür
        ProductsDto productDto = new ProductsDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());

        // Dönüştürülmüş DTO'yu geri döndür
        return productDto;
    }



}




