package com.example.ecommerce.digitalcommerce.controller.request;

import lombok.Builder;

import java.util.List;
@Builder
public record BasquetRequest(Long clientID, List<ProductRequest> products) {
}
