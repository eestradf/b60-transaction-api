package com.example.transactionapi.domain.port.in;

import com.example.transactionapi.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionUseCase {
  Flux<Transaction> findAllTransactions();

  Mono<Transaction> findTransactionById(String id);

  Mono<Transaction> findTransactionByProductId(String productId);

  Mono<Transaction> findTransactionByCustomerId(String customerId);

  Mono<Void> saveTransaction(Transaction transaction);
}
