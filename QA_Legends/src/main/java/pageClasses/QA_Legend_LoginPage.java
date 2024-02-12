package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_LoginPage {
	WebDriver driver;
	@FindBy(name="email")
	WebElement userNameField;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement loginButton;
	
	
	
	
	
	
	
	
	public QA_Legend_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void enterUserName(String userName) {
		PageUtilities.enterText(userNameField, userName);
		
	}
	public void enterPassword(String password) {
		PageUtilities.enterText(passwordField, password);
	}
	public void clickLoginButton() {
		PageUtilities.clickOnElement(loginButton);
	}
	public void closeTheWindow() {
		PageUtilities.closeBrowser(null);
	}
}
