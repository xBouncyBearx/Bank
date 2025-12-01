package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "NID",  unique = true)
    private String NID;
    @Column(name = "BDate")
    private LocalDate birthOrEstablishDate;
    @Column(name = "type")
    private CustomerType customerType;
    @Column(name = "mobile",   unique = true)
    private String mobileNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "postal")
    private String postalCode;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

}
