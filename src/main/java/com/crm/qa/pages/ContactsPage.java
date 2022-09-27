package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/div/table/thead/tr/th[1]/div/input")
	WebElement contactsCheckbox1;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContactsLink;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement newContactsFirstName;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement newContactsLastName;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement newContactsCategory;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[1]/div/input")
	WebElement newContactsEmail;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[7]/div[2]/div/div/div/div[1]/div/div[2]/div[102]/span")
	WebElement newContactsCountry;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[7]/div[2]/div/div/div/div[2]/div/input")
	WebElement newContactsPhone;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement newContactsCompany;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement newContactsSaveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}

	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String checkboxText){
		contactsLabel.click();;
		driver.findElement(By.xpath("//parent::tr//child::td[2][*[contains(.,'"+checkboxText+"')]]//parent::tr//child::td")).click();
		
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(newContactsLink);
		newContactsLink.click();
		
		
	}
	
	public void createNewContact(String category,String fName,String lName,String email,String phone,String company) {
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[2]/div/div/i")).click();
		
		if(category.equalsIgnoreCase("Lead")) {
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[2]/div/div/div[2]/div[2]/span")).click();
		}
		else if(category.equalsIgnoreCase("Customer")) {
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[2]/div/div/div[2]/div[3]/span")).click();
		}
		else if(category.equalsIgnoreCase("Affiliate")) {
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[2]/div/div/div[2]/div[5]/span")).click();
		}
		else if(category.equalsIgnoreCase("Contact")) {
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[2]/div/div/div[2]/div[4]/span")).click();
		}
		newContactsFirstName.sendKeys(fName);
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[7]/div[2]/div/div/div/div[1]/div")).click();
		newContactsCountry.click();
		newContactsPhone.sendKeys(phone);
		newContactsLastName.sendKeys(lName);
		newContactsEmail.sendKeys(email);
		newContactsCompany.sendKeys(company);
		
//		newContactsSaveBtn.click();
		
	}
}
