package com.example.transactionapi.infrastructure.repository.mapper;

import com.example.transactionapi.domain.model.Transaction;
import com.example.transactionapi.infrastructure.repository.document.TransactionDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
  Transaction toTransaction(TransactionDocument transactionDocument);

  TransactionDocument toTransactionDocument(Transaction transaction);
}
