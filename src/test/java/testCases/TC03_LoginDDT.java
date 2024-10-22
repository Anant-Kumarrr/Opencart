package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class , groups = {"Regression"})
	public void testLoginDDT(String email, String password, String exp) throws InterruptedException {

		logger.info("*** Starting TC03_LoginDDT *** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.pressLogin();
			MyAccountPage map = new MyAccountPage(driver);
			boolean result = map.myAccountPageExist();

			if (exp.equalsIgnoreCase("Valid")) {
				if (result == true) {
					map.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (result == true) {
					map.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}
			
		} catch (Exception e) {
			e.getMessage();
			Assert.assertTrue(false);
		}
		
		logger.info("*** Finished TC03_LoginDDT ***");

	}

}
