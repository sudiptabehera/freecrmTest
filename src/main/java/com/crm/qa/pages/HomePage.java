package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class HomePage extends TestBase{
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/a/span")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContactsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[5]/a/span")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[6]/a/span")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserName() {
		return userNameLabel.getAttribute("innerHTML");
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(newContactsLink);
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		
		return new TasksPage();
	}
	
	
}
