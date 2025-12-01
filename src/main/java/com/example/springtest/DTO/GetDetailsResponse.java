package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class GetDetailsResponse {
    private String name;
    private String NID;
    private LocalDate birthOrEstablishDate;
    private CustomerType customerType;
    private String mobileNumber;
    private String address;
    private String postalCode;
    private AccountStatus accountStatus;

    public GetDetailsResponse(String name, String NID, LocalDate birthOrEstablishDate, CustomerType customerType, String mobileNumber, String address, String postalCode, AccountStatus accountStatus) {
        this.name = name;
        this.NID = NID;
        this.birthOrEstablishDate = birthOrEstablishDate;
        this.customerType = customerType;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.accountStatus = accountStatus;
    }

    public GetDetailsResponse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public LocalDate getBirthOrEstablishDate() {
        return birthOrEstablishDate;
    }

    public void setBirthOrEstablishDate(LocalDate birthOrEstablishDate) {
        this.birthOrEstablishDate = birthOrEstablishDate;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
