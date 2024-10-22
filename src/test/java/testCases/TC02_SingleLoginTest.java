package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_SingleLoginTest extends BaseClass{
	
	@Test(groups = {"Regression"})
	public void login_test() {
		logger.info("*** Starting TC02_LoginTest *** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail("Kumar@gmail.com"); /* p.getProperty("EmailId") */
			lp.setPassword(p.getProperty("Password"));
			lp.pressLogin();
			MyAccountPage map = new MyAccountPage(driver);
			boolean result = map.myAccountPageExist();

			if (result == true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {
			e.getMessage();
			Assert.assertTrue(false);
		}
		
		logger.info("*** Finished TC02_SingleLoginTest ***");
	}

}
