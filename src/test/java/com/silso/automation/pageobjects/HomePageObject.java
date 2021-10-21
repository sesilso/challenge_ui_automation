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
public class HomePageObject extends PageBase{

    @Autowired
    public HomePageObject(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    private WebElement btnSignIn;

}
