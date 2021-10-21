package com.silso.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class AccountCreationPageServices {

    @Autowired
    private AccountCreationPageObject accountCreationPageObject;

    @Autowired
    private WebDriverWait wait;

    @Autowired
    private WebDriver driver;

    public void waitForCreationForm(){
        wait.until(ExpectedConditions.visibilityOf(accountCreationPageObject.getFrmAccountCreation()));
    }

    public void selectTitle(String title){
        if (title.equals("Mr.")){
            accountCreationPageObject.getRdMr().click();
        }else{
            accountCreationPageObject.getRdMrs().click();
        }
    }

    public void writeFirstName(String value){
        this.accountCreationPageObject.getTxtFirstName().sendKeys(value);
    }

    public void writeLastName(String value){
        this.accountCreationPageObject.getTxtLastName().sendKeys(value);
    }

    public void writePassword(String value){
        this.accountCreationPageObject.getTxtPassword().sendKeys(value);
    }

    public void selectDOBDay(String value){
        Select sctDay = new Select(this.accountCreationPageObject.getSelectDay());
        sctDay.selectByValue(value);
    }

    public void selectDOBMonth(String value){
        Select sctMonth = new Select(this.accountCreationPageObject.getSelectMonth());
        sctMonth.selectByValue(value);
    }

    public void selectDOBYear(String value){
        Select sctYear = new Select(this.accountCreationPageObject.getSelectYear());
        sctYear.selectByValue(value);
    }

    public void checkSignUpForNewsletter(boolean decision){
        if (decision) this.accountCreationPageObject.getChkNewsLetter().click();
    }

    public void checkReceiveSpecialOffers(boolean decision){
        if (decision) this.accountCreationPageObject.getChkReceiveOffers().click();
    }

    public void writeCompany(String value){
        this.accountCreationPageObject.getTxtCompany().sendKeys(value);
    }

    public void writeAddress1(String value){
        this.accountCreationPageObject.getTxtAddress1().sendKeys(value);
    }

    public void writeAddress2(String value){
        this.accountCreationPageObject.getTxtAddress2().sendKeys(value);
    }

    public void writeCity(String value){
        this.accountCreationPageObject.getTxtCity().sendKeys(value);
    }

    public void selectState(String value){
        Select sctState = new Select(this.accountCreationPageObject.getSelectState());
        sctState.selectByVisibleText(value);
    }

    public void writeZipCode(String value){
        this.accountCreationPageObject.getTxtPostCode().sendKeys(value);
    }

    public void selectCountry(String value){
        Select sctCountry = new Select(this.accountCreationPageObject.getSelectCountry());
        sctCountry.selectByVisibleText(value);
    }

    public void writeAdditionalInformation(String value){
        this.accountCreationPageObject.getTxtAdditionalInfo().sendKeys(value);
    }

    public void writeHomePhone(String value){
        this.accountCreationPageObject.getTxtHomePhone().sendKeys(value);
    }

    public void writeMobilePhone(String value){
        this.accountCreationPageObject.getTxtMobilePhone().sendKeys(value);
    }

    public void writeAddressAlias(String value){
        this.accountCreationPageObject.getTxtAddressAlias().clear();
        this.accountCreationPageObject.getTxtAddressAlias().sendKeys(value);
    }

    public void clickRegister(){
        this.accountCreationPageObject.getBtnSubmitAccount().click();
        System.out.println("Submit button was clicked...");
    }



}
