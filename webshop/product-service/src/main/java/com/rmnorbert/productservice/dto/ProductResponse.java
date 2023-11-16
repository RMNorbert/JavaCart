package com.rmnorbert.productservice.dto;

import com.rmnorbert.productservice.model.Product;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(String id,
                              String name,
                              String description,
                              BigDecimal price) {
    public static ProductResponse maptoProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
