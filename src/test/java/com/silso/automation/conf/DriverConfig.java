package com.silso.automation.conf;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean; //POJO
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;

import com.silso.automation.enums.Browser;
import com.silso.automation.util.driver.DriverFactory;

@Configuration
public class DriverConfig {
	
	@Value("${driver.type}")
	private Browser driverType;
	
	@Value("${element.wait.timout.seconds}")
	private int webDriverWaitTimeout;
	
	@Autowired
	private DriverFactory driverFactory;
	
	@Scope("cucumber-glue")
	@Bean(destroyMethod = "quit") 
	public WebDriver webDriver() throws MalformedURLException {
		return driverFactory.get(driverType);
	}
	
	@Bean 
	@Scope("cucumber-glue")
	public WebDriverWait waitFor() throws MalformedURLException{
		return new WebDriverWait(webDriver(),80);
	}
	
}
