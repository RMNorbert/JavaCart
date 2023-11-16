package com.rmnorbert.orderservice.service;

import com.rmnorbert.orderservice.dto.InventoryResponse;
import com.rmnorbert.orderservice.dto.OrderRequest;
import com.rmnorbert.orderservice.dto.OrderResponse;
import com.rmnorbert.orderservice.model.Order;
import com.rmnorbert.orderservice.model.OrderLineItems;
import com.rmnorbert.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private  final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItems> orderLineItemsList = orderRequest
                .orderLineItemsDtoList()
                .stream()
                .map(OrderLineItems::mapToEntityFrom)
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItemsList)
                .build();

        List<String> skuCodes = order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder ->
                                uriBuilder.queryParam("skuCode", skuCodes)
                                .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
                .allMatch(InventoryResponse::isInStock);

        if(allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock. Please try again later.");
        }
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::mapToOrderResponse)
                .toList();
    }
}
