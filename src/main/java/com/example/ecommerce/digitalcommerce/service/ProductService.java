package com.example.ecommerce.digitalcommerce.service;


import com.example.ecommerce.digitalcommerce.client.PlatziStoreClient;
import com.example.ecommerce.digitalcommerce.controller.response.PlatziStoreResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziStoreResponse> getAllProduct(){
        log.info("Getting all product");
        return platziStoreClient.getAllProduct();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziStoreResponse getProductById(Long productId){
        log.info("Getting product with ID: {}", productId);
        return platziStoreClient.getProductById(productId);
    }



}
