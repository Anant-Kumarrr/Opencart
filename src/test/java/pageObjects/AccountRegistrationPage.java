package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtPhoneNo;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkAgree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMsg;

	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNo(String phoneno) {
		txtPhoneNo.sendKeys(phoneno);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmpassword) {
		txtConfirmPassword.sendKeys(confirmpassword);
	}

	public void setPrivacyPolicy() {
		checkAgree.click();
	}

	public void pressContinue() {
		btnContinue.click();
	}

	public String getConfirmationMessage() {
		try {
			return (confirmationMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
