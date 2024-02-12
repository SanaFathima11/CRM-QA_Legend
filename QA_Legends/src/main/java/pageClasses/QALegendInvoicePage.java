package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;



public class QALegendInvoicePage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add invoice']")
	WebElement addInvoiceButton;
	@FindBy(name = "invoice_due_date")
	WebElement invoiceDueDateField;
	@FindBy(xpath = "//div[@id='s2id_invoice_client_id']")//"((//label[text()='Client']//parent::div)[3]")
	WebElement clientDropdown;
	@FindBy (xpath = "(//div[text()='AAC Corporation '])[1]")
	WebElement clientSelect;
	@FindBy (xpath = "//button[@type='submit']")//"//button[@class='btn btn-primary']")
	WebElement saveButtonForAddInvoicePopUp;
	@FindBy(xpath = "//td[text()='10']")
	WebElement dateFromPicker;
	
	
	



















public QALegendInvoicePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}




















public void clickOnAddInvoice()
{
	PageUtilities.clickOnElement(addInvoiceButton);
}
public void enterInvoiceDueDate(String invoice)
{

	PageUtilities.clickOnElement(invoiceDueDateField);
	
	
	PageUtilities.clickOnElement(dateFromPicker);
	
}
public void clickOnClientDropdown()
{
	PageUtilities.clickOnElement(clientDropdown);
	
}
public void selectFromClientDropdown()
{
	PageUtilities.clickOnElement(clientSelect);
	
}
public void clickOnSaveInAddInvoicePopUp()
{
	PageUtilities.clickOnElement(saveButtonForAddInvoicePopUp);
	
}

}