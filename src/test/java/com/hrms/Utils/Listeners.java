package com.hrms.Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	public void onTestSuccess(ITestResult result) {
		CommonMethods.takeScreen("passed/" + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		CommonMethods.takeScreen("failed/" + result.getName());
	}
}
