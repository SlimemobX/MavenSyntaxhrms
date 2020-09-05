package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.Utils.ConfigReading;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		
		ConfigReading.readProperties(System.getProperty("user.dir" + "/src/test/resources/coding/configs.properties"));
		
		switch (ConfigReading.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver=new FirefoxDriver();
			break;
			
		case "safari":
			System.setProperty("webdriver.safari.driver", "safari");
			driver = new SafariDriver();
			break;
			
		default:
			throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,  TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		driver.get(ConfigReading.getPropValue("url"));
			
	}
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
