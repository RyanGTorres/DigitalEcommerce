package com.example.ecommerce.digitalcommerce.controller;


import com.example.ecommerce.digitalcommerce.controller.request.BasquetRequest;
import com.example.ecommerce.digitalcommerce.entity.Basquet;
import com.example.ecommerce.digitalcommerce.service.BasquetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basquet")
public class BasquetController {

    private final BasquetService basquetService;

    @GetMapping("/{id}")
    public ResponseEntity<Basquet> getBasquetById(@PathVariable String id){
        return ResponseEntity.ok(basquetService.getBasquetById(id));

    }

    @PostMapping
    public ResponseEntity<Basquet> saveBasquet (@RequestBody BasquetRequest basquetRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basquetService.saveBasquest(basquetRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basquet> updateBasquet (@PathVariable String id , @RequestBody BasquetRequest basquetRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basquetService.updateBasquet(id, basquetRequest));
    }

}
