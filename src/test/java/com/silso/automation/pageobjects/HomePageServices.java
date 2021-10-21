package com.silso.automation.pageobjects;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class HomePageServices {

    @Autowired
    private HomePageObject homePageObject;

    @Autowired
    private WebDriverWait wait;

    public void clickSignIn(){
        homePageObject.getBtnSignIn().click();
    }
}
