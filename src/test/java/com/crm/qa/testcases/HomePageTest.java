package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealPage;
	TasksPage taskPage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginPage= new LoginPage();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password")); 
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Title mismatch in HOME PAGE");
	}
	
	@Test(priority=2)
	public void homePageUserNameTest() {
//		testUtil.switchToFrame();
		String userName=homePage.verifyUserName();
		Assert.assertEquals(userName, "Sudipta Behera","UserName mismatch in HOME PAGE");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
//		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}


