package com.rmnorbert.orderservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(List<OrderedLineItemsDto> orderLineItemsDtoList) {
}
