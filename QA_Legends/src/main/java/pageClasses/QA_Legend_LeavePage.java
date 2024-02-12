package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilities;

public class QA_Legend_LeavePage {
	
	WebDriver driver;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement applyLeaveButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement assignLeaveButton;
	@FindBy(xpath = "//div[@class='select2-container select2 validate-hidden']")//(xpath = "//div[@class='select2-search']")
	WebElement leaveTypeDropDown;
	@FindBy(xpath = "(//div[@class='select2-result-label'])[2]")//select2-result-label-10
	WebElement casualLeave;
	@FindBy(xpath = "//input[@id='single_date']")
	WebElement dateField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement applyLeaveButtonInPopUp;
	@FindBy(xpath = "//textarea[@name='reason']")
	WebElement reasonTextField;
	@FindBy(xpath = "//button[text()=' Apply leave']")
	WebElement leave_Apply_button;
	
	
	
	
	
	
	
	
	
	
	public QA_Legend_LeavePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnApplyLeaveButton()
	{
		PageUtilities.clickOnElement(applyLeaveButton);
	}
	public void clickOnLeaveTypeDropDown()
	{
		PageUtilities.clickOnElement(leaveTypeDropDown);
	}
	public void clickOnCasualLeave()
	{

		PageUtilities.clickOnElement(casualLeave);
	}
	public void clickOnDateField()
	{
		PageUtilities.clickOnElement(dateField);
		
	}
	public void input_LeaveDate(String l_date)
	{
		PageUtilities.enterText(dateField, l_date);
	}
	public void enterReasonForLeave(String leave_Reason)
	{
		PageUtilities.enterText(reasonTextField, leave_Reason);
	}
	public void clickOnApply_Leave_button()
	{
		PageUtilities.clickOnElement(leave_Apply_button);
		
	}











	




	
	
	
	
	
	


}
