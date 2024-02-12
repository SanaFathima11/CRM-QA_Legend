package pageClasses;

import java.time.LocalDate;import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_AnnouncementPage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()=' Add announcement']")
	WebElement button_AddAnnouncement;
	@FindBy(xpath = "//input[@id='title']")
	WebElement inputfield_announcment;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	WebElement textarea_announcement;
	@FindBy(xpath = "//input[@name='start_date']")
	WebElement input_StartDate;
	@FindBy(xpath = "//input[@name='end_date']")
	WebElement input_EndDate;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement announcement_SaveButton;
	@FindBy(xpath = "//a[@title='View']")
	WebElement announcement_View_button;
	
	
	
	
	
	
	
	
	
	public QA_Legend_AnnouncementPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}









	public void clickOn_AddAnnouncement() {
		PageUtilities.clickOnElement(button_AddAnnouncement);
	}
	public void inputTitle(String announcment_title) {
		PageUtilities.enterText(inputfield_announcment, announcment_title);
	}
	public void input_Announcement(String announcement) {
		PageUtilities.enterText(textarea_announcement, announcement);
	}
	public void input_AnnouncementStartDate(String s_date) {
		PageUtilities.enterText(input_StartDate, s_date);
	}
	public void input_AnnouncementEndDate(String e_date) {
		PageUtilities.enterText(input_EndDate, e_date);
	}
	public void scrolluptoSave() {
		PageUtilities.scrollThePage(announcement_SaveButton, driver);
	}
	public void announcement_Savebuton(){
		PageUtilities.clickOnElement(announcement_SaveButton);
	}
	public String toGetActual_View_button_Title() {
		String actualTitle = PageUtilities.getTextFromElement(announcement_View_button);
		return actualTitle;
	}
}
