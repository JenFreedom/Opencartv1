package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName ;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName ;	
@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail ;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhone ;
@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword ;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword ;
@FindBy(xpath="//input[@name='agree']") WebElement chkPolicy ;
@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue ;
@FindBy(xpath="//*[@id='content']/h1") WebElement textMessage;
	
public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPhone(String tel) {
		txtPhone.sendKeys(tel);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		return textMessage.getText();
	}
}
