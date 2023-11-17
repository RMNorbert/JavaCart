package com.rmnorbert.orderservice.model;

import com.rmnorbert.orderservice.dto.OrderedLineItemsDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order_line_items")
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public static OrderLineItems mapToEntityFrom(OrderedLineItemsDto orderedLineItemsDto) {
        return OrderLineItems.builder()
                .skuCode(orderedLineItemsDto.skuCode())
                .price(orderedLineItemsDto.price())
                .quantity(orderedLineItemsDto.quantity())
                .build();
    }
}
