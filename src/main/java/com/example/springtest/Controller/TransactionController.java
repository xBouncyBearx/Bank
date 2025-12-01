package com.example.springtest.Controller;

import com.example.springtest.DTO.GetTransactionsRequest;
import com.example.springtest.DTO.TransactionRequest;
import com.example.springtest.DTO.TransactionResponse;
import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Transaction;
import com.example.springtest.Service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getBalance")
    public Double getBalance(@RequestBody String AID) {
        return transactionService.getBalance(AID);
    }

    @PostMapping("/request")
    public TransactionResponse transactionRequest(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.transactionRequest(transactionRequest);
    }

    @GetMapping("/status/{TID}")
    public TransactionStatus getTransactionStatus(@PathVariable("TID") String TID) {
        return transactionService.getTransactionStatus(TID);
    }

    @GetMapping("/getTransactions")
    public Page<Transaction> getTransactions(@RequestBody GetTransactionsRequest getTransactionsRequest) {
        return transactionService.getTransactions(getTransactionsRequest);
    }

}
