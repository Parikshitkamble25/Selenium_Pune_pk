package com.shoppersStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath = "//span[contains(@class,'BaseBadge-root')]")
	private WebElement accountSettingBtn;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileBtn;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logoutBtn;

	public WebElement getAccountSettingBtn() {
		return accountSettingBtn;
	}

	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public  WebElement getLogoutBtn() {
		return logoutBtn;
	}


}
