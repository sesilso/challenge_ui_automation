package com.silso.automation.tasks;

import com.silso.automation.pageobjects.HomePageServices;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class NavigateTo {
	
	@Autowired
	private WebDriver webDriver;

	@Autowired
	private HomePageServices homePageServices;
	
	@Value("${initial.url}")
	private String initial_url;
	
	public void homePage() {
		this.webDriver.manage().window().maximize();
		this.webDriver.get(initial_url);
	}

	public void accountSignIn(){
		homePageServices.clickSignIn();
	}
	
}
