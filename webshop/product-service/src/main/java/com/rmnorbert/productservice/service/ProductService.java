package com.rmnorbert.productservice.service;

import com.rmnorbert.productservice.dto.ProductRequest;
import com.rmnorbert.productservice.dto.ProductResponse;
import com.rmnorbert.productservice.model.Product;
import com.rmnorbert.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product is {} saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::maptoProductResponse)
                .toList();
    }
}
