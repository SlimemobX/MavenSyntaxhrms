package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetails;
import com.hrms.pages.PimPage;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetails employee;
	public static PimPage pim;
	
	public static void initializePageObject() {
		
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		employee = new PersonalDetails();
		pim = new PimPage();
		
	}

}
