package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_Quick_AddNote {

	WebDriver driver;
	@FindBy(xpath = "//a[@id='quick-add-icon']")
	WebElement quick_Add_icon;
	@FindBy(xpath = "//a[@title='Add note']")
	WebElement quick_AddNote;
	@FindBy(xpath = "//a[@title='Add event']")
	WebElement quick_AddEvent;
	
	
	
	
	
	
	
	
	
	public QA_Legend_Quick_AddNote(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	
	
	
	
	
	
	public void clickOnQuickAddIcon() {
		PageUtilities.clickOnElement(quick_Add_icon);
	}
	public void clickOnAddNote() {
		PageUtilities.clickOnElement(quick_AddNote);
	}
	public void clickOnAddEvent() {
		PageUtilities.clickOnElement(quick_AddEvent);
	}
	
	
	
	
	
	
	
}

