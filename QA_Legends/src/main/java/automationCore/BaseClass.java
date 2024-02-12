package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

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
import pageClasses.QA_Legend_Quick_AddNote;

public class BaseClass{
	public WebDriver driver;
	FileInputStream fis;
	public Properties prop;
	public final String excelfilePath = "/src/main/java/testData/testdata_Excel.xlsx";
	
	
	public QA_Legend_LoginPage loginPage;   //obj declare
	public QA_Legend_HomePage homePage;
	public QA_Legend_EventPage eventPage;
	public QA_Legend_NotePage notePage;
	public QA_Legend_MessagePage messagePage;
	public QA_Legend_ClientPage clientPage;
	public QA_Legend_ItemPage itemPage;
	public QA_Legend_AnnouncementPage announcementPage;
	public QA_Legend_LeavePage leavePage;
	public QA_Legend_AddMember addMemberPage;
	public QALegendInvoicePage invoicepage;
	public  QA_Legend_Quick_AddNote quickaddNotePage;
	
	public WebDriver browserInitization(String browserName) throws Exception
	{
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser");
		}
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		return driver;
	}
	

	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) throws Exception 
	{
		driver = browserInitization(browser);
		driver.manage().window().maximize();
		fis = new FileInputStream("C:\\Users\\sanaa\\eclipse-workspace\\QA_Legends\\src\\main\\java\\testData\\testData.properties");
		prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		
		loginPage = new QA_Legend_LoginPage(driver); //obj initialize
		homePage = new QA_Legend_HomePage(driver);
		eventPage = new QA_Legend_EventPage(driver);
		notePage = new QA_Legend_NotePage(driver);
		messagePage = new QA_Legend_MessagePage(driver);
		clientPage = new QA_Legend_ClientPage(driver);
		itemPage = new QA_Legend_ItemPage(driver);
		announcementPage = new QA_Legend_AnnouncementPage(driver);
		leavePage = new QA_Legend_LeavePage(driver);
		addMemberPage = new QA_Legend_AddMember(driver);
		invoicepage = new QALegendInvoicePage(driver);
		quickaddNotePage = new QA_Legend_Quick_AddNote(driver);
		
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLoginButton();
		
		}
		
		public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver; 
			File source = ts.getScreenshotAs(OutputType.FILE);//screenshot capture
			String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
			Files.copy(source,new File(destinationFile));
			return destinationFile;
			//driver screenshot method
		}
		@AfterMethod
	      public void tearDown()
	      {
	    	driver.quit();
	      }

}