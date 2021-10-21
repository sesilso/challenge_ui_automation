package com.silso.automation.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dobDay;
    private String dobMonth;
    private String dobYear;
    private String company;
//    private String address;
//    private String address2;
//    private String city;
//    private String state;
//    private String zip;
//    private String country;
//    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
//    private String addressAlias;
    private Address address;
    private Preferences preferences;
}
