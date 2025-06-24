package com.example.ecommerce.digitalcommerce.repository;

import com.example.ecommerce.digitalcommerce.entity.Basquet;
import com.example.ecommerce.digitalcommerce.entity.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasquetRespository extends MongoRepository<Basquet, String> {

    Optional<Basquet> findByClientAndStatus(Long client, Status status);
}
