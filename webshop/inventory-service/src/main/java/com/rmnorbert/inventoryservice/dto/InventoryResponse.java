package com.rmnorbert.inventoryservice.dto;

import lombok.Builder;

@Builder
public record InventoryResponse (String skuCode, boolean isInStock){
}
