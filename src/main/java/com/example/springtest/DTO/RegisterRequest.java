package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.CustomerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String NID;
    private LocalDate birthOrEstablishDate;
    private CustomerType customerType;
    private String mobileNumber;
    private String address;
    private String postalCode;
    private String username;
    private String password;

    public RegisterRequest(String password, String username, String postalCode, String address, String mobileNumber, CustomerType customerType, LocalDate birthOrEstablishDate, String identifier, String name) {
        this.password = password;
        this.username = username;
        this.postalCode = postalCode;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.customerType = customerType;
        this.birthOrEstablishDate = birthOrEstablishDate;
        this.NID = identifier;
        this.name = name;
    }
}
