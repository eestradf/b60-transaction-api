package com.example.transactionapi.application.controller;

import com.example.transactionapi.application.dto.TransactionRequestDto;
import com.example.transactionapi.application.dto.TransactionResponseDto;
import com.example.transactionapi.application.mapper.TransactionInitMapper;
import com.example.transactionapi.domain.model.Transaction;
import com.example.transactionapi.domain.port.in.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionUseCase transactionUseCase;
  private final TransactionInitMapper transactionInitMapper;

  @GetMapping
  public Flux<TransactionResponseDto> getAllTransactions() {
    return this.transactionUseCase
        .findAllTransactions()
        .map(this.transactionInitMapper::toTransactionResponseDto);
  }

  @GetMapping("/{transaction-id}")
  public Mono<TransactionResponseDto> getTransactionById(
      @PathVariable(value = "transaction-id") String id) {
    return this.transactionUseCase
        .findTransactionById(id)
        .map(this.transactionInitMapper::toTransactionResponseDto);
  }

  @GetMapping("/customer/{customer-id}")
  public Mono<TransactionResponseDto> getTransactionByCustomerId(
      @PathVariable(value = "customer-id") String id) {
    return this.transactionUseCase
        .findTransactionByCustomerId(id)
        .map(this.transactionInitMapper::toTransactionResponseDto);
  }

  @PostMapping
  public Mono<Void> registerTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
    Transaction transaction = this.transactionInitMapper.toTransaction(transactionRequestDto);

    return this.transactionUseCase.saveTransaction(transaction);
  }
}
