package com.rmnorbert.orderservice.dto;

import com.rmnorbert.orderservice.model.Order;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderResponse(String orderNumber,
                            List<OrderedLineItemsDto> orderLineItemsDtoList
) {
    public static OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .orderLineItemsDtoList(
                        order.getOrderLineItemsList()
                                .stream()
                                .map(OrderedLineItemsDto::mapToOrderedLineItemsDtoFrom)
                                .toList())
                .build();
    }
}
