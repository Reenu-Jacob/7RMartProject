package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base
{
	@Test
	public void clickOnAdminUsersTab() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		//String Adminusername=ExcelUtility.getStringData(1, 0,"AdminUsers");
		//String Adminpassword=ExcelUtility.getStringData(1, 1,"AdminUsers");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
		boolean displayedOrNot=loginPage.isDashboardDisplayed();
		Assert.assertTrue(displayedOrNot, "Home page not loaded");
		
		AdminUsersPage adminuser=new AdminUsersPage(driver);
		FakerUtility faker=new FakerUtility();
		String Adminusername=faker.creatARandomFirstName();
		String Adminpassword=faker.creatARandomLastName();
		adminuser.clickOnAdminUser();
		adminuser.clickOnNewButtoninAdminUser();
		adminuser.enterUserName(Adminusername);
		adminuser.enterPassword(Adminpassword);
		adminuser.selectUserType();
		adminuser.clickOnSave();
		boolean Alertdisplayed=adminuser.alertMessageOnAdminUser();
		Assert.assertTrue(Alertdisplayed, "Alert not displayed");
		
	}

}
