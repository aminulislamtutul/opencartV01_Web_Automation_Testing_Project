package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountLoginPage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import utilities.DataProviders;

public class DDTestAccountLoginPage_TC003 extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven")// getting data provider from different class
	public void verifyDDTestLoginPage(String email, String pwd, String exp) {
		
		logger.info  ("****Starting DDTestAccountLoginPage_TC003****");	
		try {
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		AccountLoginPage lp = new AccountLoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//My Account Page
		MyAccountPage macp = new MyAccountPage(driver);
		boolean targetpage = macp.isMyAccountPageExists();
		
		/*Data is valid  - login success - test pass  - logout
			login failed - test fail

          Data is invalid - login success - test fail  - logout
			login failed - test pass
        */

		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				macp.clickLogoutButton();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				macp.clickLogoutButton();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}	
		
		logger.info("End DDTestAccountLoginPage_TC003");
		
	}

}
