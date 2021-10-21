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
public class AuthenticationPageObject extends PageBase{

    @Autowired
    public AuthenticationPageObject(WebDriver driver) {super(driver);}

    @FindBy(id = "email_create")
    private WebElement txtEmailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement btnSubmitCreate;

    @FindBy(xpath = "//div[@id='create_account_error']/ol/li")
    private WebElement alertError;
}
