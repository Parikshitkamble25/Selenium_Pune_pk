package com.shoppersStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddress_Page {
	public MyAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
}	

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;
	
	
	@FindBy(xpath = "(//span[@class='MuiButton-startIcon MuiButton-iconSizeSmall css-u0g51i'])[2]")
	private WebElement delAddBtn;
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesBtn;
	
	@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-w0pj6f'])[3]")
	private WebElement editBtn;
	
	@FindBy(xpath = "//button[text()='Update Address']")
	private WebElement updateAddBtn;
	
	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getUpdateAddBtn() {
		return updateAddBtn;
	}

	public WebElement getDelAddBtn() {
		return delAddBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
		
		
	}
	
	
}

	



