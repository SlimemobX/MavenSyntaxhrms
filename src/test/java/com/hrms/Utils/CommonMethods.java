package com.hrms.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer{
	
	/**
	 * Method that sends text to any given element
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Method return object of JavaScript Executor type
	 * @return js object
	 */
	public static JavascriptExecutor getJsExecutor() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js;
	}
	
	/**
	 * Method performs click using JavaScript executor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJsExecutor().executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Method used to scroll upusing JavaScript Executor
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJsExecutor().executeScript("window.scrollBy(0, -"+pixel+")");
	}
	
	/**]
	 * Method used to scroll down using JavaScript Executor
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJsExecutor().executeScript("window.scrollBy(0, "+pixel+")");
	}
	
	/**
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constant.EXPLICIT_WAIT_TIME);
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void waitForClickAbility(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickAbility(element);
		element.click();
	}
	
	

}
