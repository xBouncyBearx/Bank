package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public class GetTransactionsRequest {

    private Long tid;
    private String fromAccount;
    private String toAccount;
    private TransactionType type;
    private TransactionStatus status;
    private Double minAmount;
    private Double maxAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public GetTransactionsRequest(Long tid, String fromAccount, String toAccount, TransactionType type, TransactionStatus status, Double minAmount, Double maxAmount, LocalDateTime startDate, LocalDateTime endDate) {
        this.tid = tid;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.type = type;
        this.status = status;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public GetTransactionsRequest() {}

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
