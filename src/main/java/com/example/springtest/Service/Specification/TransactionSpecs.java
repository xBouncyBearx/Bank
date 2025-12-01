package com.example.springtest.Service.Specification;

import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;
import com.example.springtest.Entity.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TransactionSpecs {

    public static Specification<Transaction> tid(Long tid) {
        return (root, query, cb) -> cb.equal(root.get("transactionId"), tid);
    }

    public static Specification<Transaction> type(TransactionType type) {
        return (root, query, cb) -> cb.equal(root.get("transactionType"), type);
    }

    public static Specification<Transaction> status(TransactionStatus status) {
        return (root, query, cb) -> cb.equal(root.get("transactionStatus"), status);
    }

    public static Specification<Transaction> amountBetween(Double min, Double max) {
        return (root, query, cb) -> cb.between(root.get("amount"), min, max);
    }

    public static Specification<Transaction> createdBetween(LocalDateTime start, LocalDateTime end) {
        return (root, query, cb) -> cb.between(root.get("createDate"), start, end);
    }

    public static Specification<Transaction> fromAccount(String from) {
        return (root, query, cb) -> cb.equal(root.get("from"), from);
    }

    public static Specification<Transaction> toAccount(String to) {
        return (root, query, cb) -> cb.equal(root.get("to"), to);
    }
}

