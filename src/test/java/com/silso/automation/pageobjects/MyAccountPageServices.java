package com.silso.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class MyAccountPageServices {

    @Autowired
    private MyAccountPageObject myAccountPageObject;

    @Autowired
    private WebDriverWait wait;

    @Autowired
    private WebDriver driver;

    public void waitForNavigation(){
        wait.until(ExpectedConditions.visibilityOf(this.myAccountPageObject.getLblNavigation()));
    }

    public boolean SignOutOptionPresence(){
        return myAccountPageObject.getBtnLogOut().isDisplayed();
    }

    public String getUsername(){
        return this.wait.until(ExpectedConditions.visibilityOf(myAccountPageObject.getTxtUsername())).getText();
    }

    public String currentUrl(){
        return this.driver.getCurrentUrl();
    }

}
