package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "NID")
    private String NID;
    @Column(name = "BDate")
    private LocalDate birthOrEstablishDate;
    @Column(name = "type")
    private CustomerType customerType;
    @Column(name = "mobile")
    private String mobileNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "postal")
    private String postalCode;
    @Column(name = "status")
    private AccountStatus accountStatus;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

}
