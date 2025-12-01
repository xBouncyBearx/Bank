package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name = "AID",  unique = true)
    private String AID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "status")
    private AccountStatus accountStatus;

    @Column(name = "username",  unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Double balance;
}
