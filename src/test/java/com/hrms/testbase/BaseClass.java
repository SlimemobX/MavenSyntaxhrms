package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.Utils.ConfigReading;
import com.hrms.Utils.Constant;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		
		ConfigReading.readProperties(Constant.CODING_FILEPATH);
		
		switch (ConfigReading.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_FILEPATH);
			driver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constant.GECKODRIVER_FILEPATH);
			driver=new FirefoxDriver();
			break;
			
		case "safari":
			System.setProperty("webdriver.safari.driver", Constant.SAFARI_FILEPATH);
			driver = new SafariDriver();
			break;
			
		default:
			throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT_TIME,  TimeUnit.SECONDS);
		driver.get(ConfigReading.getPropValue("applicationUrl"));
		PageInitializer.initializePageObject();
			
	}
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
