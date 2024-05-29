package com.shoppers.testScripts;

import org.testng.annotations.Test;

import com.shoppersStack.GenericUtility.BaseTest;
import com.shoppersStack.Pom.HomePage;
import com.shoppersStack.Pom.MyAddress_Page;
import com.shoppersStack.Pom.MyProfile_Page;


public class verify_user_is_able_to_delete_address_or_not extends BaseTest {
	@Test
	public void delAddress() {
		homePage.getAccountSettingBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfile=new MyProfile_Page(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddress_Page myAddPage=new MyAddress_Page(driver);
		myAddPage.getDelAddBtn().click();
		
		myAddPage.getYesBtn().click();
		driver.switchTo().alert().accept();
		
	}

}
