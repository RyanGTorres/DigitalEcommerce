package com.example.ecommerce.digitalcommerce.controller;


import com.example.ecommerce.digitalcommerce.controller.response.PlatziStoreResponse;
import com.example.ecommerce.digitalcommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity <List<PlatziStoreResponse>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlatziStoreResponse> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
