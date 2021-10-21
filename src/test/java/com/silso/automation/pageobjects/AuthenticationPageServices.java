package com.silso.automation.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Scope("cucumber-glue")
@Component
public class AuthenticationPageServices {
    @Autowired
    private AuthenticationPageObject authenticationPageObject;

    @Autowired
    private WebDriverWait wait;

    @Autowired
    private WebDriver driver;

    public void writeEmailForCreation(String newEmail){
        wait.until(ExpectedConditions.elementToBeClickable(authenticationPageObject.getTxtEmailCreate())).clear();
        authenticationPageObject.getTxtEmailCreate().sendKeys(newEmail);
    }

    public void clickSubmitCreate(){
        wait.until(ExpectedConditions.elementToBeClickable(authenticationPageObject.getBtnSubmitCreate())).click();
    }

    public boolean captureNewEmailError(){
        try{
            fluentWait().until(ExpectedConditions.visibilityOf(authenticationPageObject.getAlertError()));
            System.out.println("Error : "  + authenticationPageObject.getAlertError().getText());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Wait<WebDriver> fluentWait(){
        return new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
    }

}
