package com.example.transactionapi.domain.service;

import com.example.transactionapi.domain.model.Transaction;
import com.example.transactionapi.domain.port.in.TransactionUseCase;
import com.example.transactionapi.domain.port.out.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionUseCase {
  private final TransactionRepositoryPort transactionRepositoryPort;

  @Override
  public Flux<Transaction> findAllTransactions() {
    return this.transactionRepositoryPort.findAllTransactions();
  }

  @Override
  public Mono<Transaction> findTransactionById(String id) {
    return this.transactionRepositoryPort.findTransactionById(id);
  }

  @Override
  public Mono<Transaction> findTransactionByProductId(String productId) {
    return null;
  }

  @Override
  public Mono<Transaction> findTransactionByCustomerId(String customerId) {
    return this.transactionRepositoryPort.findTransactionByCustomerId(customerId);
  }

  @Override
  public Mono<Void> saveTransaction(Transaction transaction) {
    return this.transactionRepositoryPort.saveTransaction(transaction);
  }
}
