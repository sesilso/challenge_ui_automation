package com.silso.automation.util.reporting;

import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class InstantPicHook {

	@Autowired
	private WebDriver webDriver;
	
	@Value("${take.instantpic.condition:none}")
	private InstantPicCondition instantPicCondition;
	
//	@After
//	public void takeInstantPicAfterScenario(Scenario scenario) {
//		if(InstantPicCondition.endOfScenario == instantPicCondition) {
//			takeInstantPic(scenario);
//		}
//	}
//	
//	@AfterStep
//	public void takeInstantPicAfterEveryStep(Scenario scenario) {
//		if(InstantPicCondition.everyStep == instantPicCondition) {
//			takeInstantPic(scenario);
//		}	
//	}
//	
	@After
	public void takeInstantPicAfterFailingScenario(Scenario scenario) {
		if(scenario.isFailed() &&  InstantPicCondition.failingScenario == instantPicCondition) {
			takeInstantPic(scenario);
		}
	}
	
	public void takeInstantPic(Scenario scenario) {		
		try {
			final byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",UUID.randomUUID().toString());
		} catch (WebDriverException wde) {
			System.out.println("Error : InstantPic could not take the picture! = " + wde.getMessage());
		}		
	}
	
}
