package com.example.ecommerce.digitalcommerce.controller;


import com.example.ecommerce.digitalcommerce.controller.request.BasquetRequest;
import com.example.ecommerce.digitalcommerce.entity.Basquet;
import com.example.ecommerce.digitalcommerce.service.BasquetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basquet")
public class BasquetController {

    private final BasquetService basquetService;

    @PostMapping
    public ResponseEntity<Basquet> saveBasquet (@RequestBody BasquetRequest basquetRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basquetService.saveBasquest(basquetRequest));

    }

}
