package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealPage;
	TasksPage taskPage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	String sheetName="Sheet";
	
	public ContactsPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginPage= new LoginPage();
		
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password")); 
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabel() {
//		testUtil.switchToFrame();
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact label is missing");
	}
	
	@Test(priority=8)
	public void selectContactTest() {
//		testUtil.switchToFrame();
		contactsPage.selectContactsByName("Sudipta Behera");
//		contactsPage.selectContactsByName("Malaya Sahoo");
//		contactsPage.selectContactsByName("Aditya Gupta");
//		contactsPage.selectContactsByName("Rohit Behera");
//		contactsPage.selectContactsByName("Shubhasmita Rakshit");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4)
	public void validateCreateNewContact() throws InterruptedException { 
//		testUtil.switchToFrame();
		contactsPage.clickOnNewContactLink();
		contactsPage.createNewContact("Lead", "Sudama", "Singh", "SUD@fsd.com","911","TCS");
		
		
	}
	
	@Test(priority=5, dataProvider="getCRMTestData")
	public void validateCreateNewContactXL(String fname,String lname,String status,String phone,String email,String company,String category) throws InterruptedException { 
//		testUtil.switchToFrame();
		contactsPage.clickOnNewContactLink();
//		contactsPage.createNewContact("Lead", "Sudama", "Singh", "SUD@fsd.com");
		contactsPage.createNewContact(category,fname,lname,email,phone,company);
		
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

