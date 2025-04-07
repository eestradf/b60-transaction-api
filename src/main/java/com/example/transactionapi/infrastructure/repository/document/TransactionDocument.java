package com.example.transactionapi.infrastructure.repository.document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "transaction")
public class TransactionDocument {
  @Id private String id;
  private String customerId;
  private String transactionType;
  private BigDecimal amount;
  private LocalDateTime transactionDate;
  private String description;
}
