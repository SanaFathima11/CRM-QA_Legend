package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_HomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Lekshmi Nair']")
	WebElement userProfileName;
	@FindBy(xpath = "//a[text()=' Sign Out']")
	WebElement logoutButton;
	@FindBy(xpath = "//span[text()='Events']")
	WebElement dashboard_Events;
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement dashboard_Notes;
	@FindBy(xpath = "//span[text()='Messages']")
	WebElement dashboardMessage;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement dashboard_Clients;
	@FindBy(xpath = "//span[text()='Items']")
	WebElement dashboard_Items;
	@FindBy(xpath = "//span[text()='Announcements']")
	WebElement dashboard_Announcements;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement dashboard_Leave;
	
	@FindBy(xpath = "//div[@id='sidebar-scroll']")
	WebElement dashboar_Scrol;
	
	@FindBy(xpath="//a[text()=' Add event']")
	WebElement button_AddEvent;
	@FindBy(xpath="//span[text()='Team members']")
	WebElement dashboard_teammember;
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement invoicehomebutton;
	
	
	
	
	
	
	
	public QA_Legend_HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}







	public void clickOnUserProfileName() {
		PageUtilities.clickOnElement(userProfileName);
	}
	public void clickOnLogoutButton() {
		PageUtilities.clickOnElement(logoutButton);
	}
	public String getProfileName() {
		return PageUtilities.getTextFromElement(userProfileName);
	}
	public void clickonDashboardEvents() {
		PageUtilities.clickOnElement(dashboard_Events);
	}
	public void clickOnDashboardNotes() {
		PageUtilities.clickOnElement(dashboard_Notes);
	}
	public void clickOnDashboardMessage() {
		PageUtilities.clickOnElement(dashboardMessage);
	}
	public void clickOnDashboardClients() {
		PageUtilities.clickOnElement(dashboard_Clients);
	}
	public void clickOnDashboardItem() {
		PageUtilities.clickOnElement(dashboard_Items);
	}
	public void clickOnDashboardAnnouncements() {
		PageUtilities.clickOnElement(dashboard_Announcements);
	}
	public void clickOnDashboardLeave() {
		PageUtilities.clickOnElement(dashboard_Leave);
	}
	public void scrollSidepanel() {
		PageUtilities.scrollThePage(dashboard_Announcements, driver);
	}
	public void clickon_teammember()
	{
		
	PageUtilities.clickOnElement(dashboard_teammember);
	}
	public void clickOnInvoiceButton()
	{
	PageUtilities.clickOnElement(invoicehomebutton);
	}
	}
	

