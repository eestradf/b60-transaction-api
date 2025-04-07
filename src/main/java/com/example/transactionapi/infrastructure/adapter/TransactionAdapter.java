package com.example.transactionapi.infrastructure.adapter;

import com.example.transactionapi.domain.model.Transaction;
import com.example.transactionapi.domain.port.out.TransactionRepositoryPort;
import com.example.transactionapi.infrastructure.repository.TransactionRepository;
import com.example.transactionapi.infrastructure.repository.document.TransactionDocument;
import com.example.transactionapi.infrastructure.repository.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TransactionAdapter implements TransactionRepositoryPort {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  @Override
  public Flux<Transaction> findAllTransactions() {
    return this.transactionRepository.findAll().map(this.transactionMapper::toTransaction);
  }

  @Override
  public Mono<Transaction> findTransactionById(String id) {
    return this.transactionRepository.findById(id).map(this.transactionMapper::toTransaction);
  }

  @Override
  public Mono<Transaction> findTransactionByProductId(String productId) {
    return null;
  }

  @Override
  public Mono<Transaction> findTransactionByCustomerId(String customerId) {
    return this.transactionRepository
        .findTransactionDocumentByCustomerId(customerId)
        .map(this.transactionMapper::toTransaction);
  }

  @Override
  public Mono<Void> saveTransaction(Transaction transaction) {
    TransactionDocument transactionDocument =
        this.transactionMapper.toTransactionDocument(transaction);

    return this.transactionRepository.save(transactionDocument).then();
  }
}
