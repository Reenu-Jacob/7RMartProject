package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{

	@FindBy(xpath="//section[@class='content']/div/div/div[7]/div/a")WebElement moreInfoLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement newButtonLink;
	@FindBy(xpath="//textarea[@id='news']")WebElement newsTextBox;
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageNews() 
	{
		moreInfoLink.click();
	}
	
	public void clickOnNewButton()
	{
		newButtonLink.click();
	}
	
	public void enterNewsInTextBox(String news)
	{
		newsTextBox.sendKeys(news);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public boolean alertDisplayed()
	{
		return alertmsg.isDisplayed();
	}
}
