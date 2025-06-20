package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(retryAnalyzer=retry.Retry.class,groups=("Regression"))
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException 
	{
		 //String username="admin";
		 //String password="admin";
		 String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		 
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean displayedOrNot=loginPage.isDashboardDisplayed();
		 Assert.assertTrue(displayedOrNot, "Home page not loaded");
	}
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingInvalidUserCredentials() 
	{
		 String username="invalid";
		 String password="admin";
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Username");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassCredentials() 
	{
		 String username="admin";
		 String password="invalid";
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Password");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUserAndPassCredentials() 
	{
		 String username="invalid";
		 String password="invalid";
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Username and Password");
	}
}
