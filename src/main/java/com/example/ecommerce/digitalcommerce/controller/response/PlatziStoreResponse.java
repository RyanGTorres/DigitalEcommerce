package com.example.ecommerce.digitalcommerce.controller.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziStoreResponse(Long id, String title, BigDecimal price) implements Serializable {
}
