package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountLoginPage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TestAccountLoginPage_TC002 extends BaseClass {
	@Test(groups = {"Sanity","Master"})
	 public void verifyLogin(){
	        logger.info("****Starting TestAccountLoginPageTC002****");
	        try {
	            HomePage homePage = new HomePage(driver);
	            logger.info("Clicking on My Account Link..");
	            homePage.clickMyAccount();
	            logger.info("Clicking on Login Link..");
	            homePage.clickLogin();
	            //Login Page
	            AccountLoginPage accountLoginPage = new AccountLoginPage(driver);
	            accountLoginPage.setEmailAddress(properties.getProperty("emailAddress"));
	            accountLoginPage.setPassword(properties.getProperty("loginPassword"));
	            accountLoginPage.clickLogin();

	            //My Account Page
	            MyAccountPage myAccountPage = new MyAccountPage(driver);
	            boolean targetPage = myAccountPage.isMyAccountPageExists();
	            Assert.assertTrue(targetPage);
	        }catch (Exception e) {
	            Assert.fail();
	        }

	        logger.info("****End TestAccountLoginPageTC002****");
	    }

}
