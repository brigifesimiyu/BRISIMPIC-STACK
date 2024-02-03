package com.example.demo.Details;


public class Details {
    private long pId;
    private String fullName;
    private String email;
    private String password;


    public Details(long pId,
                   String fullName,
                   String email,
                   String password) {
        this.pId = pId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Details(String fullName,
                   String email,
                   String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Details{" +
                "pId=" + pId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


