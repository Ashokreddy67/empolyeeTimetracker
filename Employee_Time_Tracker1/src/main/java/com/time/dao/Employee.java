package com.time.dao;

public class Employee {

    private String name;
    private String password;
    private String role;
    private String email;
    private String dob;
    private String mobileNo;

    public Employee(String name, String password, String role, String email, String dob, String mobileNo) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.dob = dob;
        this.mobileNo = mobileNo;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
}
