package com.silso.automation.util.reporting;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.io.IOException;

public class JReportListener implements ConcurrentEventListener{
	
	public void onTestCaseStarted(TestCaseStarted event) {
		TestCase testCase = event.getTestCase();
		System.out.println("Test Case execution started :" + testCase.getName());
	}
	
	private void onTestCaseFinished(final TestCaseFinished event){
		TestCase testCase = event.getTestCase();
		System.out.println("Test Case execution ended : " + testCase.getName());
		Result result = event.getResult();		
		if(result.getStatus() == Status.FAILED) {
			final Throwable error = result.getError();
			error.printStackTrace();
		}			
		
	}
	
	public void onTestRunFinished(TestRunFinished event) throws IOException {
		boolean performImportation = false;
		System.out.println("Finishing test run..." + "Importation process value = " + performImportation );
	}
	
	public void setEventPublisher(EventPublisher publisher) {
		
		publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
		publisher.registerHandlerFor(TestCaseFinished.class,this::onTestCaseFinished);
		publisher.registerHandlerFor(TestRunFinished.class, event -> {
			try {
				onTestRunFinished(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}
	
}
