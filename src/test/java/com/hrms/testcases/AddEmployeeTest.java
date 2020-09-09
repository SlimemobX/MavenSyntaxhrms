package com.hrms.testcases;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReading;
import com.hrms.Utils.Constant;
import com.hrms.Utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{

	@Test(groups = "regression", dataProvider = "addingData")
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
	
	@Test (groups = "regression")
	
	public void addMultiEmp() {
		sendText(login.userNameTextBox, ConfigReading.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigReading.getPropValue("password"));
		click(login.loginBtn);
		
		click(dashboard.pimLinkBtn);
		click(pim.addEmpButton);
		
		List<Map<String, String>> employeeList = ExcelUtility.excelToListMap(Constant.TESTDATA_FILEPATH, "Sheet1");
		SoftAssert soft = new SoftAssert();
		for (Map<String, String> map: employeeList) {
			String firstName = map.get("Firstname");
			String lastName = map.get("Lastname");
			
			sendText(addEmp.firstName, firstName);
			sendText(addEmp.lastName, lastName);
			click(addEmp.saveButton);
			soft.assertEquals(employee.pictureText.getText(), firstName + " " + lastName);
		}
		soft.assertAll();
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
