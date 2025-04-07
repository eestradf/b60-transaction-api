package com.example.transactionapi.application.dto;

import com.example.transactionapi.domain.model.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TransactionRequestDto {
  private String customerId;
  private TransactionType transactionType;
  private BigDecimal amount;
  private LocalDateTime transactionDate;
  private String description;
}
