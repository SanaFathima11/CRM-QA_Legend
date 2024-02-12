package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtilities;

public class QA_Legend_MessagePage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Compose']")
	WebElement message_Compose_button;
	@FindBy(xpath = "(//span[contains(@id,'select2-chosen')])[1]")
	WebElement composeInputfield_To;
	
	
	
	
	
	
	
	public QA_Legend_MessagePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}







	public void clickOnCompose() {
		PageUtilities.clickOnElement(message_Compose_button);
		//PageUtilities.clickByJavaScript(composeInputfield_To, driver);
	}
	public void clickOnTo() {
		//PageUtilities.clickOnElement(composeInputfield_To);
		WaitUtilities.waitFowaitForAnElementToBeVisible(driver, composeInputfield_To);
		PageUtilities.clickByJavaScript(composeInputfield_To, driver);
	}
	
	public void inputRecipiantName(String to_address) {
		//PageUtilities.enterText(composeInputfield_To, to_address);
		
		PageUtilities.enterTextByJavaScript(driver, composeInputfield_To, to_address);
	}
	public void selectRecipiant() {
		Select sObj = new Select(composeInputfield_To);
		sObj.selectByIndex(1);
	}
	
}
