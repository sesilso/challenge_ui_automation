package com.silso.automation.tasks;

import com.silso.automation.models.Account;
import com.silso.automation.pageobjects.AccountCreationPageServices;
import com.silso.automation.pageobjects.AuthenticationPageServices;
import com.silso.automation.pageobjects.HomePageServices;
import com.silso.automation.util.RandomEmailGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class Register {

    @Autowired
    private HomePageServices homePageServices;

    @Autowired
    private AuthenticationPageServices authenticationPageServices;

    @Autowired
    private AccountCreationPageServices accountCreationPageServices;

    public void withInfo(Account account) {
        authenticateEmail(account);
        fillRegistrationForm(account);
        accountCreationPageServices.clickRegister();
    }

    public void authenticateEmail(Account account){
        authenticationPageServices.writeEmailForCreation(account.getEmail());
        authenticationPageServices.clickSubmitCreate();
        while (authenticationPageServices.captureNewEmailError()){
            account.setEmail(RandomEmailGenerator.get());
            System.out.println("Random email rejected - new email attempt : " + account.getEmail());
            authenticationPageServices.writeEmailForCreation(account.getEmail());
            authenticationPageServices.clickSubmitCreate();
        }
    }

    public void fillRegistrationForm(Account account){
        accountCreationPageServices.waitForCreationForm();
        accountCreationPageServices.selectTitle(account.getTitle());
        accountCreationPageServices.writeFirstName(account.getFirstName());
        accountCreationPageServices.writeLastName(account.getLastName());
        accountCreationPageServices.writePassword(account.getPassword());
        accountCreationPageServices.selectDOBDay(account.getDobDay());
        accountCreationPageServices.selectDOBMonth(account.getDobMonth());
        accountCreationPageServices.selectDOBYear(account.getDobYear());
        accountCreationPageServices.checkSignUpForNewsletter(account.getPreferences().getSignUpNewsletter());
        accountCreationPageServices.checkReceiveSpecialOffers(account.getPreferences().getReceiveOffers());
        accountCreationPageServices.writeCompany(account.getCompany());
        accountCreationPageServices.writeAddress1(account.getAddress().getAddress1());
        accountCreationPageServices.writeAddress2(account.getAddress().getAddress2());
        accountCreationPageServices.writeCity(account.getAddress().getCity());
        accountCreationPageServices.selectState(account.getAddress().getState());
        accountCreationPageServices.selectState(account.getAddress().getState());
        accountCreationPageServices.writeZipCode(account.getAddress().getZip());
        accountCreationPageServices.selectCountry(account.getAddress().getCountry());
        accountCreationPageServices.writeAdditionalInformation(account.getAddress().getAdditionalInformation());
        accountCreationPageServices.writeHomePhone(account.getHomePhone());
        accountCreationPageServices.writeMobilePhone(account.getMobilePhone());
        accountCreationPageServices.writeAddressAlias(account.getAddress().getAddressAlias());
    }
}
