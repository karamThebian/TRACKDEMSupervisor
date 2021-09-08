package com.example.trackdem;

class Person {
    final int x = 10;
    private String firstName; // Person First Name
    private String lastName; // Person Last Name
    private String dateOfBirth; // Person Date of birthday
    private String id;
    private String password;
    public Person(String fName, String lName, String dob,String id,String password) {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setDobOfBirth(dob);
        this.setId(id);
        this.setPassword(password);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public String getId() {
        return this.id;
    }
    public String getPassword() {
        return this.password;
    }
    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    public void setId(String i) {
        this.id = i;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setDobOfBirth(String dob) {
        this.dateOfBirth = dob;
    }}
