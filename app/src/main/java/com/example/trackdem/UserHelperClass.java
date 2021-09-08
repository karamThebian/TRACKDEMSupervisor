package com.example.trackdem;

public class UserHelperClass {
    String fullName,password,phoneNumber,username;

    public UserHelperClass() {
    }

    public UserHelperClass(String fullName, String password, String phoneNumber, String username) {
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}