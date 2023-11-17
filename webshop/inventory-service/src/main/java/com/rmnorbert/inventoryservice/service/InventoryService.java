package com.rmnorbert.inventoryservice.service;

import com.rmnorbert.inventoryservice.dto.InventoryResponse;
import com.rmnorbert.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final static int OUT_OF_STOCK_THRESHOLD = 0;
    @Transactional(readOnly= true)
    public  List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > OUT_OF_STOCK_THRESHOLD)
                            .build())
                .toList();
    }
}
