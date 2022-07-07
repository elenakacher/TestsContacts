package com.telran.contacts;

import org.testng.annotations.Test;

public class Contact {
    private String vorname;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String descriprion;

    public Contact setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setDescriprion(String descriprion) {
        this.descriprion = descriprion;
        return this;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDescriprion() {
        return descriprion;
    }

}
