package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage 
{
	@FindBy(xpath="//section[@class='content']/div/div/div[1]/div/a")WebElement moreInfoLink;
	@FindBy(xpath="//section[@class='content']/div/a[1]")WebElement newButtonLink;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement selectAdmin;
	@FindBy(xpath="//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminUser() 
	{
		moreInfoLink.click();
	}
	
	public void clickOnNewButtoninAdminUser()
	{
		newButtonLink.click();
	}
	
	public void enterUserName(String adminUsername)
	{
		username.sendKeys(adminUsername);
	}
	
	public void enterPassword(String adminPassword)
	{
		password.sendKeys(adminPassword);
	}
	
	public void selectUserType()
	{
		//Select sc=new Select(selectAdmin);
		//sc.selectByValue("Admin");
		PageUtility pageutility=new PageUtility();
		pageutility.selectByValue(selectAdmin, "admin");
	}
	
	public void clickOnSave()
	{
		saveButton.click();
	}
	
	public boolean alertMessageOnAdminUser()
	{
		return alertMessage.isDisplayed() ;
		
	}
}
