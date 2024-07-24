package com.barros.hexagonal.application.core.domain;

import lombok.Data;

@Data
public class Address {

    public Address() {

    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    private String street;

    private String city;

    private String state;
}
