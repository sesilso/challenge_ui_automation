package com.silso.automation.builders.data;

import com.silso.automation.models.Account;
import com.silso.automation.models.Address;
import com.silso.automation.models.Preferences;
import com.silso.automation.util.RandomEmailGenerator;

public class AccountBuilder {
    private Account account;

    public AccountBuilder(){account = Account.builder().build();}

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    public AccountBuilder withDefaultInfo() {
        this.account = Account.builder()
                .title("Mr.")
                .firstName("Michael")
                .lastName("Jackson")
                .email(RandomEmailGenerator.get())
                .password("automation@123")
                .dobDay("25")
                .dobMonth("12")
                .dobYear("1991")
                .company("Automation Co.")
                .address(Address.builder()
                        .address1("Javier Prado 2021")
                        .address2("Av Aviacion 2020")
                        .city("San Diego")
                        .state("California")
                        .zip("20021")
                        .country("United States")
                        .additionalInformation("Near Train Station")
                        .addressAlias("Main Train Address").build())
                .homePhone("019568745")
                .mobilePhone("+51978542165")
                .preferences(Preferences.builder()
                        .signUpNewsletter(true)
                        .receiveOffers(false).build())
                .build();
        return this;
    }

    public Account build() {
        return this.account;
    }

}
