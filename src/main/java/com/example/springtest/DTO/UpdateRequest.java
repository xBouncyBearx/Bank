package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UpdateRequest extends  RegisterRequest {
    @Column(name = "status")
    private AccountStatus accountStatus;

    public UpdateRequest(String password, String username, String postalCode, String address, String mobileNumber, CustomerType customerType, LocalDate birthOrEstablishDate, String identifier, String name, AccountStatus accountStatus) {
        super(password, username, postalCode, address, mobileNumber, customerType, birthOrEstablishDate, identifier, name);
        this.accountStatus = accountStatus;
    }
}
