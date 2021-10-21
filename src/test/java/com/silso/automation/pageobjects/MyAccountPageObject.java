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
public class MyAccountPageObject extends PageBase{

    @Autowired
    public MyAccountPageObject(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//span[@class='navigation_page' and contains(text(),'My account')]")
    private WebElement lblNavigation;

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement txtUsername;

    @FindBy(xpath = "//a[@class='logout' and contains(text(), 'Sign out')]")
    private WebElement btnLogOut;

}
