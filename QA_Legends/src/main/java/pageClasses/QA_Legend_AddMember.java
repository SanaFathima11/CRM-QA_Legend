package pageClasses;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtilities;

public class QA_Legend_AddMember
{

WebDriver driver;
@FindBy(xpath = "//a[text()=' Add member']")
WebElement click_addmember;
@FindBy(xpath = "//input[@id='first_name']")
WebElement click_MemberFirstname;
@FindBy(xpath = "//input[@name='last_name']")
WebElement click_MemberLastname;
@FindBy(xpath = "//button[@id='form-next']")
WebElement click_nextbutton;
@FindBy(xpath = "//input[@name='job_title']")
WebElement click_jobtitile;
@FindBy(xpath = "//button[@id='form-next']")
WebElement click_nextbutton2;
@FindBy(xpath = "//input[@name='email']")
WebElement click_emailaddress;
@FindBy(xpath="//input[@name='password']")
WebElement click_password;
@FindBy(xpath = "//button[@id='form-submit']")
WebElement click_savebutton;
@FindBy(xpath ="//table//tbody//tr//td//a[text()='Sana Fathima ']")
WebElement searchdisplayname;

















public QA_Legend_AddMember(WebDriver driver) 
{
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}





public void clickon_addmember()
{
	PageUtilities.clickOnElement(click_addmember);
	}
public void enter_title(String title)
{
	PageUtilities.enterText(click_MemberFirstname, title);
	}
public void enter_title2(String title_2)
{
	PageUtilities.enterText(click_MemberLastname,title_2);
	}
public void click_nextbutton()
{
	WaitUtilities.waitFowaitForAnElementToBeVisible(driver, click_nextbutton);
	PageUtilities.clickOnElement(click_nextbutton);}

public void enter_jobtitle(String jobtitle)
{
	PageUtilities.enterText(click_jobtitile, jobtitle);
	}

public void click_nextbutton2()
{
	PageUtilities.clickOnElement(click_nextbutton2);
	}
public void enter_mailadddress(String mailaddress)
{
	PageUtilities.enterText(click_emailaddress, mailaddress);
	}
public void enter_password(String password)
{
	PageUtilities.enterText(click_password, password);
	}
public void click_savebutton()
{
	PageUtilities.clickOnElement(click_savebutton);
	}
public boolean memeber_Visibility() 
{
	 return searchdisplayname.isDisplayed();
	
}
}













