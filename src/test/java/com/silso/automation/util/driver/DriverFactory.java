package com.silso.automation.util.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.silso.automation.conf.Configurations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.silso.automation.enums.Browser;

@Component
public class DriverFactory {
	
	@Value("${remote.execution}")
	private boolean remoteExecution;

	@Value("${driver.manager}")
	private boolean driverManager;

	@Value("${remote.type}")
	private String remoteType;

	@Value("${remote.user}")
	private String remoteUser;

	@Value("${remote.key}")
	private String remoteKey;


	
	public WebDriver get(Browser browser) throws MalformedURLException {
		
		System.out.println(remoteExecution + " - "+ remoteType);
		
		if(remoteExecution) {
				String USERNAME = remoteUser;
				String ACCESS_KEY = remoteKey;
				String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
							
				MutableCapabilities sauceOptions = new MutableCapabilities();

				if(Browser.chrome == browser){
					ChromeOptions browserOptions = new ChromeOptions();
					browserOptions.setCapability("platformName", "Windows 10");
					browserOptions.setCapability("browserVersion", "86.0");
					browserOptions.setCapability("sauce:options", sauceOptions);
					return new RemoteWebDriver(new URL(URL),browserOptions);
				}if(Browser.firefox == browser){
					FirefoxOptions browserOptions = new FirefoxOptions();
					browserOptions.setCapability("platformName", "Windows 10");
					browserOptions.setCapability("browserVersion", "92");
					browserOptions.setCapability("sauce:options", sauceOptions);
					return new RemoteWebDriver(new URL(URL),browserOptions);
				}if(Browser.edge == browser){
					EdgeOptions browserOptions = new EdgeOptions();
					browserOptions.setCapability("platformName", "Windows 10");
					browserOptions.setCapability("browserVersion", "93");
					browserOptions.setCapability("sauce:options", sauceOptions);
					return new RemoteWebDriver(new URL(URL),browserOptions);
				}
				if(Browser.safari == browser){
					SafariOptions browserOptions = new SafariOptions();
					browserOptions.setCapability("platformName", "macOS 10.15");
					browserOptions.setCapability("browserVersion", "13");
					browserOptions.setCapability("sauce:options", sauceOptions);
					return new RemoteWebDriver(new URL(URL),browserOptions);
				}else{
					ChromeOptions browserOptions = new ChromeOptions();
					browserOptions.setCapability("platformName", "Windows 10");
					browserOptions.setCapability("browserVersion", "86.0");
					browserOptions.setCapability("sauce:options", sauceOptions);
					return new RemoteWebDriver(new URL(URL),browserOptions);
				}

		}
				
		if(Browser.chrome == browser) {
			if(driverManager){
				WebDriverManager.chromedriver().setup();
			}else{
				System.setProperty("webdriver.chrome.driver", Configurations.modifyIfWindows(Configurations.CHROME_DRIVER_PATH));
			}
			return new ChromeDriver();
		}
		if(Browser.firefox == browser) {
			if(driverManager){
				WebDriverManager.firefoxdriver().setup();
			}else {
				System.setProperty("webdriver.gecko.driver", Configurations.modifyIfWindows(Configurations.FIREFOX_DRIVER_PATH));
			}
			return new FirefoxDriver();
		}
		if(Browser.edge == browser) {
			if(driverManager){
				WebDriverManager.edgedriver().setup();
			}else {
				System.setProperty("webdriver.edge.driver", Configurations.modifyIfWindows(Configurations.EDGE_DRIVER_PATH));
			}
			return new EdgeDriver();
		}
		
		throw new IllegalArgumentException("Driver not found in DriverFactory for browser:" + browser );
	}
	
}
