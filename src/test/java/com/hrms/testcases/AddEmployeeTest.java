package com.hrms.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReading;

public class AddEmployeeTest extends CommonMethods{

	@Test(dataProvider = "addingData")
	public void addEmp(String firstName, String lastName, String userName, String password) {

		sendText(login.userNameTextBox, ConfigReading.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigReading.getPropValue("password"));
		click(login.loginBtn);
		
		click(dashboard.pimLinkBtn);
		click(pim.addEmpButton);
		
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName, userName);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.confirmPassword, password);
		click(addEmp.saveButton);
		waitForVisibility(employee.pictureText);
		Assert.assertEquals(employee.pictureText.getText(), firstName + " " + lastName);
		
	}
	
	@DataProvider
	public Object[][] addingData(){
		Object[][] information = {
				{"Mariana", "Fernandes", "Mfernandes", "Fernandes$90283"},
				{"Jake", "Bonucci", "BonucciJ", "Jbonucci$38266"},
				{"Blake","Drogonov","DrogoBlake", "Drogonov$83809"}
		
			};
		return information;
	}

	private void waitForVisibility(WebElement pictureText) {
		// TODO Auto-generated method stub
		
	}

		
	
}
