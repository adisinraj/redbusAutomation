package com.redbus.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl implements ITestListener {
	
	static Logger LOGGER = Logger.getLogger(ITestListenerImpl.class);
	
	
	public void onTestStart(ITestResult result) {
		LOGGER.info("Test start : "+result.getName());
	}

	
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("Passed test are:"+result.getName());
	}

	
	public void onTestFailure(ITestResult result) {
		LOGGER.error("Test Failed : "+result.getName());
	}

	
	public void onTestSkipped(ITestResult result) {
		LOGGER.warn("skipped test are"+result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Do nothing
	}

	
	public void onStart(ITestContext context) {
		LOGGER.info("Test Started : "+context.getName());
	}

	
	public void onFinish(ITestContext context) {
		LOGGER.info("Test Finished : "+context.getName());
	}


}
