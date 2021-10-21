package com.silso.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	features="src/test/resources/features"
					,plugin = {
							"pretty", "html:target/cucumber-html-report.html",
							"json:target/cucumber-reports/Cucumber.json",
							"com.silso.automation.util.reporting.JReportListener"
							},publish = false
)
public class CucumberTest{
	
}