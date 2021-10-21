package com.silso.automation.questions;
import com.silso.automation.models.Account;
import com.silso.automation.pageobjects.MyAccountPageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Scope("cucumber-glue")
@Component
public class RegisterQuestions {

    @Autowired
    private MyAccountPageServices myAccountPageServices;

    @Value("${initial.url}")
    private String base_url;

    public void isUsernameCorrect(Account account){
        String expectedUsername = String.format("%s %s",account.getFirstName(),account.getLastName());
        String actualUsername = myAccountPageServices.getUsername();
        assertThat(actualUsername).isEqualTo(expectedUsername);
    }

    public void isLogOutOptionAvailable(){
        assertThat(myAccountPageServices.SignOutOptionPresence()).isTrue();
    }

    public void isCurrentUrlCorrect(){
        String expectedUrl= "?controller=my-account";
        String actualUrl =  myAccountPageServices.currentUrl().replace(base_url,"");
        assertThat(actualUrl).isEqualTo(expectedUrl);
    }

}
