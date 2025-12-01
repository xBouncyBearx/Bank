package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.CustomerType;

import java.time.LocalDate;

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

    public RegisterRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNID() {
        return NID;
    }

    public void setIdentifier(String identifier) {
        this.NID = identifier;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
