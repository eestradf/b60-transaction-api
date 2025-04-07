package com.example.transactionapi.infrastructure.repository;

import com.example.transactionapi.infrastructure.repository.document.TransactionDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TransactionRepository
    extends ReactiveMongoRepository<TransactionDocument, String> {
  Mono<TransactionDocument> findTransactionDocumentByCustomerId(String customerId);
}
