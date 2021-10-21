package com.silso.automation.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
@Getter
public class AccountCreationPageObject extends PageBase{

    @Autowired
    public AccountCreationPageObject(WebDriver driver) {super(driver);}

    @FindBy(id = "account-creation_form")
    private WebElement frmAccountCreation;

    @FindBy(id = "id_gender1")
    private WebElement rdMr;

    @FindBy(id = "id_gender2")
    private WebElement rdMrs;

    @FindBy(id = "customer_firstname")
    private WebElement txtFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement txtLastName;

    @FindBy(id = "passwd")
    private WebElement txtPassword;

    @FindBy(id = "days")
    private WebElement selectDay;

    @FindBy(id = "months")
    private WebElement selectMonth;

    @FindBy(id = "years")
    private WebElement selectYear;

    @FindBy(id = "newsletter")
    private WebElement chkNewsLetter;

    @FindBy(id = "optin")
    private WebElement chkReceiveOffers;

    @FindBy(id = "company")
    private WebElement txtCompany;

    @FindBy(id = "address1")
    private WebElement txtAddress1;

    @FindBy(id = "address2")
    private WebElement txtAddress2;

    @FindBy(id = "city")
    private WebElement txtCity;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement txtPostCode;

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "other")
    private WebElement txtAdditionalInfo;

    @FindBy(id = "phone")
    private WebElement txtHomePhone;

    @FindBy(id = "phone_mobile")
    private WebElement txtMobilePhone;

    @FindBy(id = "alias")
    private WebElement txtAddressAlias;

    @FindBy(id = "submitAccount")
    private WebElement btnSubmitAccount;

}
