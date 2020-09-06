package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;


import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReading;


public class LoginTest extends CommonMethods{

	@Test(groups = "smoke")
	public void validLogin() {

		sendText(login.userNameTextBox, ConfigReading.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigReading.getPropValue("password"));
		click(login.loginBtn);

		Assert.assertTrue(dashboard.welcomeAdmin.isDisplayed());
	}

	
	@Test(groups = "regression",  dataProvider="invalidCredentials")
	public void invalidLogin(String username,String password, String text) {
		sendText(login.userNameTextBox, username);
		sendText(login.passwordTextBox, password);
		click(login.loginBtn);
		AssertJUnit.assertEquals(login.spanMessage.getText(), text);
	}
	
	@DataProvider
	public String [][] invalidCredentials(){
			String [][] data={
			{"", "Hum@nhrm123", "Username cannot be empty"},
			{"Admin", "", "Password cannot be empty"},
			{"Admin", "Hum@nhrm12", "Invalid credentials"},
//			
	};
	return data;
	}

}
