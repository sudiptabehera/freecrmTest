package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory -OR:
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement LogInBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement LogoChk;
	//Initializing page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
//	
//	public boolean validateCRMImage() {
//		return LogoChk.isDisplayed();
//	}
	
	public HomePage login(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		LogInBtn.click();
		
		return new HomePage();
		
	}
}
