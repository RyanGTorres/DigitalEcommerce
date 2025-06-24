package com.example.ecommerce.digitalcommerce.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Builder
@Getter
@Setter
public class Product {

    //puxa da API externa

    private Long id;

    private String title;

    private BigDecimal price;

    private Integer quantity;

}
