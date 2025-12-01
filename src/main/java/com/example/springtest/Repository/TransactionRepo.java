package com.example.springtest.Repository;

import com.example.springtest.Entity.Transaction;
import org.springframework.data.jpa.repository.*;

public interface TransactionRepo extends JpaRepository<Transaction,Long>, JpaSpecificationExecutor<Transaction> {
    Transaction findByTransactionId(String transactionId);
}
