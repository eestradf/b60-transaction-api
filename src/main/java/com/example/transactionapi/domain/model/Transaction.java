package com.example.transactionapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {
  private String id;
  private String customerId;
  private TransactionType transactionType;
  private BigDecimal amount;
  private LocalDateTime transactionDate;
  private String description;
}
