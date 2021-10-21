package com.silso.automation;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.silso.automation.conf.TestConfig;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class, StartApplication.class}, loader=SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
	
	@Before
	public void setup() {
		System.out.println("Context started!");
	}
}
