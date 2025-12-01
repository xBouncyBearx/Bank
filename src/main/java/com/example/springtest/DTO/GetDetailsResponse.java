package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailsResponse {
    private String name;
    private String NID;
    private LocalDate birthOrEstablishDate;
    private CustomerType customerType;
    private String mobileNumber;
    private String address;
    private String postalCode;
    private AccountStatus accountStatus;
}
