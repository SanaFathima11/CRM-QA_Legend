  package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import dev.failsafe.internal.util.Assert;
import pageClasses.QALegendInvoicePage;
import pageClasses.QA_Legend_AddMember;
import pageClasses.QA_Legend_AnnouncementPage;
import pageClasses.QA_Legend_ClientPage;
import pageClasses.QA_Legend_EventPage;
import pageClasses.QA_Legend_HomePage;
import pageClasses.QA_Legend_ItemPage;
import pageClasses.QA_Legend_LeavePage;
import pageClasses.QA_Legend_LoginPage;
import pageClasses.QA_Legend_MessagePage;
import pageClasses.QA_Legend_NotePage;
import utilities.DateUtilities;
import utilities.ExcelUtility;
import utilities.FakerUtilities;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class QA_LegendTestCases extends BaseClass
{
	public WebDriver driver;
	
	
	
	
	
	@Test(priority = 1,groups = {"reggression"})
	
	public void loginCRM() 
	{ 
		homePage.clickOnUserProfileName();
		homePage.clickOnLogoutButton();
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		String expectedUserName = prop.getProperty("profileName");   //assertion
		String actualUserName = homePage.getProfileName();
		org.testng.Assert.assertEquals(actualUserName, expectedUserName);
		
		
		
	}
	
	@Test(priority = 2,groups = {"smoketest"})
	
	public void addMember() throws IOException, AWTException
	{
		
		  homePage.clickon_teammember();
	addMemberPage.clickon_addmember();
	String add_firstname=ExcelUtility.getString(1, 0, excelfilePath,"addmember")+FakerUtilities.randomNumberCreation();
	addMemberPage.enter_title(add_firstname);
	String add_secondname = ExcelUtility.getString(1, 1,excelfilePath,"addmember")+FakerUtilities.randomNumberCreation();
	addMemberPage.enter_title2(add_secondname);
	addMemberPage.click_nextbutton();
	String add_jobtitle=ExcelUtility.getString(1, 2, excelfilePath, "addmember")+FakerUtilities.randomNumberCreation();
	addMemberPage.enter_jobtitle(add_jobtitle);
	addMemberPage.click_nextbutton2();
	String add_mailaddress=ExcelUtility.getString(1, 3, excelfilePath, "addmember")+FakerUtilities.randomNumberCreation();
	addMemberPage.enter_mailadddress(add_mailaddress);
	String add_passsword=ExcelUtility.getString(1, 4, excelfilePath, "addmember")+FakerUtilities.randomNumberCreation();
	addMemberPage.enter_password(add_passsword);
	addMemberPage.click_savebutton();
	org.testng.Assert.assertEquals(addMemberPage.memeber_Visibility(), true);


		 
	}
	
	
	
	
	
	
	
	@Test(priority = 3,groups = {"smoketest"})
	public void add_Notes() throws IOException, AWTException, InterruptedException
	{
		homePage.clickOnDashboardNotes();

		notePage.clickOn_AddNote_button();
		String noteTitle=ExcelUtility.getString(1, 0, excelfilePath, "Note_Page")+FakerUtilities.randomNumberCreation();
		notePage.addNote_inputTitle(noteTitle);
		String noteDescription=ExcelUtility.getString(1, 1, excelfilePath, "Note_Page");
		notePage.addNote_inputDescription(noteDescription);
		
		
		String path = "C:\\Users\\sanaa\\eclipse-workspace\\QA_Legends\\src\\main\\java\\testData\\testData.properties";
		notePage.upload_image(path);
		Thread.sleep(3000);
		
		notePage.clickOnNote_Save_button();
		
		
		String actualNoteTitle = notePage.toGetActualNoteTitle(); //assertion
		org.testng.Assert.assertEquals(actualNoteTitle, noteTitle);
		
	}
	
	
	
	@Test(priority = 4,groups = {"smoketest"})
	public void add_Client() throws IOException 
	{
		homePage.clickOnDashboardClients();
		clientPage.clickOnAddClient();
		String companyName=ExcelUtility.getString(1, 0, excelfilePath, "Sheet2");
		clientPage.inputCompanyName(companyName);
		String address=ExcelUtility.getString(1, 1, excelfilePath, "Sheet2");
		clientPage.inputAddress(address);
		String city=ExcelUtility.getString(1, 2, excelfilePath, "Sheet2");
		clientPage.inputCity(city);
		String state=ExcelUtility.getString(1, 3, excelfilePath, "Sheet2");
		clientPage.inputState(state);
		String country=ExcelUtility.getString(1, 4, excelfilePath, "Sheet2");
		clientPage.inputCountry(country);
		clientPage.clickOnClientSave_button();
		
		
		clientPage.search_added_company(companyName);
		String addedCmpany = clientPage.getPre_added_Client();
		org.testng.Assert.assertEquals(companyName, addedCmpany);
		
		
	}
	
	@Test(dataProvider = "test_login_credentials")
	public void loginScnrios(String userName, String password)
	{
		homePage.clickOnUserProfileName();
		homePage.clickOnLogoutButton();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		
		
		
	}
	@DataProvider(name = "test_login_credentials")
	public Object[][] testData(){
		Object [][] login_data = new Object[3][2];
		login_data[0][0] = "admin@admin.com";
		login_data[0][1] = "12345678";
		login_data[1][0] = "admin@adm.com";
		login_data[1][1] = "12345678";
		login_data[2][0] = "admin@admin.com";
		login_data[2][1] = "123456789";
		return login_data;
		
	}
	
	
	@Test(priority = 5,groups = {"reggression"})
	public void add_Announcements() throws IOException, AWTException, InterruptedException 
	{
		
		//PageUtilities.scrollToBottom(driver, 1000);
		homePage.scrollSidepanel();
		homePage.clickOnDashboardAnnouncements();
		announcementPage.clickOn_AddAnnouncement();
		String announcment_title=ExcelUtility.getString(1, 0, excelfilePath, "Announcement")+FakerUtilities.randomNumberCreation();
		announcementPage.inputTitle(announcment_title);
		PageUtilities.enter_TAB_Key();
		String announcment=ExcelUtility.getString(1, 1, excelfilePath, "Announcement");
		announcementPage.input_Announcement(announcment);
		String s_date = DateUtilities.getCurrentDate();
		announcementPage.input_AnnouncementStartDate(s_date);
		
		String e_date = s_date;
		announcementPage.input_AnnouncementEndDate(e_date);
		announcementPage.scrolluptoSave();
		
		
		
		
		announcementPage.announcement_Savebuton();

		String actual_ViewButton_Title = announcementPage.toGetActual_View_button_Title();
		String expected_ViewButton_Title = "View";
		org.testng.Assert.assertEquals(actual_ViewButton_Title, expected_ViewButton_Title);
		

		
	}
	
	
	@Test(priority = 6,groups = {"reggression"})
	
	public void add_Item() throws IOException 
	{
		
		homePage.clickOnDashboardItem();
		itemPage.clickOnAddItem();
		String event_Title=ExcelUtility.getString(1, 0, excelfilePath, "Note_Page")+FakerUtilities.randomNumberCreation();
		itemPage.inputTitle(event_Title);
		String item_Description=ExcelUtility.getString(1, 1, excelfilePath, "Note_Page");
		itemPage.inputItemDescription(item_Description);
		String item_Rate=ExcelUtility.getString(1, 1, excelfilePath, "Note_Page");
		itemPage.inputItemRate(item_Rate);
		itemPage.clickon_item_Save();
		String item = event_Title;
		itemPage.search_added_item(item);
		String adde_item = itemPage.getPre_added_Item();	
		org.testng.Assert.assertEquals(event_Title, adde_item);
		
		
		
	}
	
	@Test(priority = 7,groups = {"reggression"})
	
	public void applyAndAssignLeave() throws IOException, InterruptedException 
	{	
		homePage.scrollSidepanel();
		homePage.clickOnDashboardLeave();
		String title_ofLeave_Page=PageUtilities.getTitleOfThePage(driver);
		leavePage.clickOnApplyLeaveButton();
		leavePage.clickOnLeaveTypeDropDown();
		leavePage.clickOnCasualLeave();
		String l_date = DateUtilities.getCurrentDate();
		leavePage.input_LeaveDate(l_date);
		String leave_Reason=ExcelUtility.getString(1, 0, excelfilePath, "Leave");
		
		leavePage.enterReasonForLeave(leave_Reason);
		leavePage.clickOnApply_Leave_button();
		String title_ofthe_Page = PageUtilities.getTitleOfThePage(driver);
		org.testng.Assert.assertEquals(title_ofLeave_Page, title_ofthe_Page);
		 
	}
@Test(priority = 8,groups = {"reggression"})

public void addinvoice() throws IOException, InterruptedException
{
	 homePage.clickOnInvoiceButton();
		invoicepage.clickOnAddInvoice();
	
		invoicepage.enterInvoiceDueDate(excelfilePath);
		invoicepage.clickOnClientDropdown();
		invoicepage.selectFromClientDropdown();
		Thread.sleep(2000);
		invoicepage.clickOnSaveInAddInvoicePopUp();
}


@Test(priority = 9,groups = {"smoketest"}  )  
	 
	
public void addNoteusingQuickIcon() throws IOException, AWTException, InterruptedException
{
	quickaddNotePage.clickOnQuickAddIcon();
	quickaddNotePage.clickOnAddNote();
	String noteTitle=ExcelUtility.getString(1, 0, excelfilePath, "Note_Page")+FakerUtilities.randomNumberCreation();
	notePage.addNote_inputTitle(noteTitle);
	String noteDescription=ExcelUtility.getString(1, 1, excelfilePath, "Note_Page");
	notePage.addNote_inputDescription(noteDescription);		
	String path = prop.getProperty("screenshot_Path");
	notePage.upload_image(path);
	Thread.sleep(3000);
	notePage.clickOnNote_Save_button();
	Thread.sleep(2000);
	homePage.clickOnDashboardNotes();  
	String actualNoteTitle = notePage.toGetActualNoteTitle();
	org.testng.Assert.assertEquals(actualNoteTitle, noteTitle);
}

@Test(priority= 10,groups = {"smoketest"})
public void addEvent() throws IOException 
{
	homePage.clickonDashboardEvents();
	eventPage.clickonAddEvents();
	
	String event_Title=ExcelUtility.getString(1, 0, excelfilePath, "Sheet1")+FakerUtilities.randomNumberCreation();
	eventPage.inputTitle(event_Title);
	String event_Description_=ExcelUtility.getString(1, 1, excelfilePath, "Sheet1");
	eventPage.inputEventDescription(event_Description_);
	//System.out.println(DateUtilities.getCurrentDate());
	String startDate = DateUtilities.getCurrentDate();
	String startTime = DateUtilities.getCurrenttime();
	eventPage.inputEventStartDate(startDate);
	//eventPage.inputEventStartTime(startTime);
	String endDate = startDate;
	eventPage.inputEventEndDate(endDate);
	String event_Location=ExcelUtility.getString(1, 2, excelfilePath, "Sheet1");
	eventPage.inputEventLocation(event_Location);
	eventPage.clickon_Event_Save();
}


}
	
	


