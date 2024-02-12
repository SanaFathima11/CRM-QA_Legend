package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QA_Legend_ItemPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()=' Add item']")
	WebElement button_AddItem;
	@FindBy(xpath="//input[@id='title']")
	WebElement additem_Title;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement additem_Description;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement additem_Save_button;
	@FindBy(xpath = "//input[@id='item_rate']")
	WebElement additem_Rate;
	@FindBy(xpath = "//input[@type='search']")
	WebElement item_searchBox;
	@FindBy(xpath = "(//table[@id='item-table']//ancestor::td)[1]")
	WebElement previously_added_Item;
	
	
	
	
	
	
	
	
	public QA_Legend_ItemPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	public void clickOnAddItem() {
		PageUtilities.clickOnElement(button_AddItem);
	}
	public void inputTitle(String event_Title) {
		PageUtilities.enterText(additem_Title, event_Title);
	}
	public void inputItemDescription(String item_Description) {
		PageUtilities.enterText(additem_Description, item_Description);
	}
	public void inputItemRate(String item_Rate) {
		PageUtilities.enterText(additem_Rate, item_Rate);
	}
	public void clickon_item_Save() {
		PageUtilities.clickOnElement(additem_Save_button);
	}
	public void search_added_item(String item) {
		PageUtilities.enterText(item_searchBox, item);
	}
	public String getPre_added_Item() {
		String prev_Added_Item =PageUtilities.getTextFromElement(previously_added_Item);
		return prev_Added_Item;
	}
	
	
}
