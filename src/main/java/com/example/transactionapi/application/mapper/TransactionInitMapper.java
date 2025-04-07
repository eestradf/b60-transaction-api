package com.example.transactionapi.application.mapper;

import com.example.transactionapi.application.dto.TransactionRequestDto;
import com.example.transactionapi.application.dto.TransactionResponseDto;
import com.example.transactionapi.domain.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionInitMapper {
  TransactionResponseDto toTransactionResponseDto(Transaction transaction);

  Transaction toTransaction(TransactionRequestDto transactionRequestDto);
}
