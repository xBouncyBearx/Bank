package com.example.springtest.Entity;


import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends BaseEntity {


    @Column(name = "TID")
    private String transactionId;
    @Column(name = "type")
    private TransactionType transactionType;
    @Column(name = "status")
    private TransactionStatus transactionStatus;
    @Column(name = "fromAC")
    private String from;
    @Column(name = "toAC")
    private String to;
    @Column(name = "amount")
    private Double amount;
}
