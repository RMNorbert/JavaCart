package com.rmnorbert.orderservice.dto;

import com.rmnorbert.orderservice.model.OrderLineItems;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record OrderedLineItemsDto(String skuCode,
                                  BigDecimal price,
                                  Integer quantity) {

    public static OrderedLineItemsDto mapToOrderedLineItemsDtoFrom(OrderLineItems orderLineItems) {
        return OrderedLineItemsDto.builder()
                .skuCode(orderLineItems.getSkuCode())
                .price(orderLineItems.getPrice())
                .quantity(orderLineItems.getQuantity())
                .build();
    }
}
