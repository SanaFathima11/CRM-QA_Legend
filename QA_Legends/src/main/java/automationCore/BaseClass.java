package automationCore;

import java.io.File;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;



public class BaseClass{
	public WebDriver driver;
	
	public final String excelfilePath = "/src/main/java/testData/testdata_Excel.xlsx";
	
	
	
	
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
	

	
		
		public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver; 
			File source = ts.getScreenshotAs(OutputType.FILE);//screenshot capture
			String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
			Files.copy(source,new File(destinationFile));
			return destinationFile;
			//driver screenshot method
		}
		
}