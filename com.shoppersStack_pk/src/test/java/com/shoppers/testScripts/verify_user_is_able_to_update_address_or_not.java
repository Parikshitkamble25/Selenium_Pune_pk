package com.shoppers.testScripts;

import com.shoppersStack.GenericUtility.BaseTest;
import com.shoppersStack.Pom.AddressForm_Page;
import com.shoppersStack.Pom.MyAddress_Page;
import com.shoppersStack.Pom.MyProfile_Page;

public class verify_user_is_able_to_update_address_or_not extends BaseTest{
	
	@org.testng.annotations.Test
	public void updateAddress() {
		homePage.getAccountSettingBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfile=new MyProfile_Page(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddress_Page myAddPage=new MyAddress_Page(driver);
		myAddPage.getEditBtn().click();
		
		AddressForm_Page addFormPage=new AddressForm_Page(driver);
		addFormPage.getNameTF().clear();
		addFormPage.getAddAdressBtn().sendKeys("parikshit");
		
		myAddPage.getUpdateAddBtn().click();
	
	}
	

}
