package com.example.transactionapi.domain.port.out;

import com.example.transactionapi.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionRepositoryPort {
  Flux<Transaction> findAllTransactions();

  Mono<Transaction> findTransactionById(String id);

  Mono<Transaction> findTransactionByProductId(String productId);

  Mono<Transaction> findTransactionByCustomerId(String customerId);

  Mono<Void> saveTransaction(Transaction transaction);
}
