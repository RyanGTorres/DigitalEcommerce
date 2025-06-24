package com.example.ecommerce.digitalcommerce.client;

import com.example.ecommerce.digitalcommerce.controller.response.PlatziStoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${digital.client.platzi}")
public interface PlatziStoreClient {


    @GetMapping("/products")
    List<PlatziStoreResponse> getAllProduct();

    @GetMapping("/products/{id}")
    PlatziStoreResponse getProductById (@PathVariable Long id);
}
