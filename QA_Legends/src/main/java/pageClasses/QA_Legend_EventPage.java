package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_EventPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()=' Add event']")
	WebElement button_AddEvent;
	@FindBy(xpath="//input[@id='title']")
	WebElement inputfield_Title;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement inputfield_Description;
	@FindBy(xpath = "//input[@name='start_date']")
	WebElement inputfield_StartDate;
	@FindBy(xpath = "//input[@name='start_time']")
	WebElement inputfield_StartTime;
	@FindBy(xpath = "//input[@name='end_date']")
	WebElement inpufied_EndDate;
	@FindBy(xpath = "//input[@id='location']")
	WebElement inputfield_location;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement event_Save_button;
	
	
	
	
	
	
	
	
	public QA_Legend_EventPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}









	public void  clickonAddEvents() {
		PageUtilities.clickOnElement(button_AddEvent);
	}
	public void clickonTitleField() {
		PageUtilities.clickOnElement(inputfield_Title);
	}
	public void inputTitle(String event_Title) {
		PageUtilities.enterText(inputfield_Title, event_Title); 
	}
	public void inputEventDescription(String event_Description) {
		PageUtilities.enterText(inputfield_Description, event_Description);
	}
	public void inputEventStartDate(String startDate) {
		PageUtilities.enterText(inputfield_StartDate, startDate);
	}
	public void inputEventStartTime(String startTime) {
		PageUtilities.enterText(inputfield_StartTime, startTime);
	}
	public void inputEventEndDate(String endDate) {
		PageUtilities.enterText(inpufied_EndDate, endDate);
	}
	public void inputEventLocation(String event_Location) {
		PageUtilities.enterText(inputfield_location, event_Location);
	}
	public void clickon_Event_Save() {
		PageUtilities.clickOnElement(event_Save_button);
	}
}
