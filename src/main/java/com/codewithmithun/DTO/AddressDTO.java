package com.codewithmithun.DTO;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String landmark;
}
