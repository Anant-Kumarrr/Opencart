package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass{

	@Test(groups = {"Smoke"})
	public void verify_account_registration() {
		
		logger.info("*** Starting TC01_AccountRegistrationTest ***");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked On My Account");
		hp.clickRegister();
		logger.info("Clicked On Registration");
		
		try {
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing Customer Details");
			regpage.setFirstName(randomString());
			regpage.setLastName(randomString());
			String mailId = randomString() + "@gmail.com";
			regpage.setEmail(mailId);
			regpage.setPhoneNo(randomNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);;
			regpage.setPrivacyPolicy();
			regpage.pressContinue();
			String message = regpage.getConfirmationMessage();
			
			if(message.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC01_AccountRegistrationTest ***");
		
	}
	
}
