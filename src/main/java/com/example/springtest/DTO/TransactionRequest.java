package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private TransactionType transactionType;
    private String from;
    private String to;
    private Double amount;
}
