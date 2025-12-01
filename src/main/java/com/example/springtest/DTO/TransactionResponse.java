package com.example.springtest.DTO;

public class TransactionResponse {

    private String response;
    private String transactionId;

    public TransactionResponse(String response, String transactionId) {
        this.response = response;
        this.transactionId = transactionId;
    }

    public TransactionResponse() {}

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
