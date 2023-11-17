package com.rmnorbert.orderservice.dto;

import lombok.Builder;

@Builder
public record InventoryResponse(String skuCode, boolean isInStock){
}
