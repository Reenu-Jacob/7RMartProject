package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test
	public void clickOnMoreInfoInManageNews() throws IOException 
	{
		//LoginTest loginTest=new LoginTest();
		//loginTest.verifyTheUserIsAbleToLoginUsingValidCredentials();
		/*String news="Hello world";
		String username="admin";
		String password="admin";*/
		String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		String news=ExcelUtility.getStringData(1, 0,"ManageNews");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
		boolean displayedOrNot=loginPage.isDashboardDisplayed();
		Assert.assertTrue(displayedOrNot, "Home page not loaded");
		ManageNewsPage manageNews=new ManageNewsPage(driver);
		manageNews.clickOnManageNews();
		manageNews.clickOnNewButton();
		manageNews.enterNewsInTextBox(news);
		manageNews.clickOnSaveButton();
		boolean isAlertDisplayed=manageNews.alertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "Success Alert displayed");
	}
}
