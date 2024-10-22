package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void pressLogin() {
		btnLogin.click();
	}

}