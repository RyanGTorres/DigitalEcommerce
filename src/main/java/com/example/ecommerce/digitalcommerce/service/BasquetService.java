package com.example.ecommerce.digitalcommerce.service;

import com.example.ecommerce.digitalcommerce.controller.request.BasquetRequest;
import com.example.ecommerce.digitalcommerce.controller.response.PlatziStoreResponse;
import com.example.ecommerce.digitalcommerce.entity.Basquet;
import com.example.ecommerce.digitalcommerce.entity.Product;
import com.example.ecommerce.digitalcommerce.entity.enums.Status;
import com.example.ecommerce.digitalcommerce.repository.BasquetRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasquetService {

    private final BasquetRespository basquetRespository;
    private final ProductService productService;

    public Basquet saveBasquest (BasquetRequest basquetRequest){

        basquetRespository.findByClientAndStatus(basquetRequest.clientID(), Status.OPEN)
                .ifPresent(basquet -> {
                    throw new IllegalArgumentException("There is already an open basket for this client");
                });


        List<Product> products = new ArrayList<>();
        basquetRequest.products().forEach(productRequest -> {
            PlatziStoreResponse platziStoreResponse = productService.getProductById(productRequest.id());


            products.add(Product.builder()
                    .id(platziStoreResponse.id())
                    .title(platziStoreResponse.title())
                    .price(platziStoreResponse.price())
                    .quantity(productRequest.quantity())
                    .build());

        });

        Basquet basquet = Basquet.builder()
                .client(basquetRequest.clientID())
                .status(Status.OPEN)
                .products(products)
                .build();

        basquet.calculateTotalPrice();
        return basquetRespository.save(basquet);
    }
}
