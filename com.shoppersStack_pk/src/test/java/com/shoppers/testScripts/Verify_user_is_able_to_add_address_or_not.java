package com.shoppers.testScripts;

import java.io.IOException;
import org.testng.annotations.Test;



import com.shoppersStack.GenericUtility.BaseTest;
import com.shoppersStack.Pom.HomePage;
import com.shoppersStack.Pom.MyAddress_Page;
import com.shoppersStack.Pom.MyProfile_Page;

public class Verify_user_is_able_to_add_address_or_not extends BaseTest {
	@Test
	public void addAddress() throws IOException, InterruptedException {
		homePage.getAccountSettingBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfile=new MyProfile_Page(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddress_Page myAddPage=new MyAddress_Page(driver);
		myAddPage.getAddAddressBtn().click();
		Thread.sleep(2000);
		
		 
		
		com.shoppersStack.Pom.AddressForm_Page addressformpage=new com.shoppersStack.Pom.AddressForm_Page(driver);
		
		addressformpage.getNameTF().sendKeys(utility.readExcelData("Sheet1", 1, 0));
		addressformpage.getHouseTF().sendKeys(utility.readExcelData("Sheet1", 1, 1));
		addressformpage.getStreetTF().sendKeys(utility.readExcelData("Sheet1", 1, 2));
		addressformpage.getLandmarkTF().sendKeys(utility.readExcelData("Sheet1", 1, 3));;
		
		webUtility.selectByValue(addressformpage.getCountryDD(),utility.readPropertyData("country"));
		webUtility.selectByValue(addressformpage.getStateDD(),utility.readPropertyData("state"));
		webUtility.selectByValue(addressformpage.getCityDD(),utility.readPropertyData("city"));
		
		addressformpage.getPincodTF().sendKeys(utility.readExcelData("Sheet1", 1, 4));
		addressformpage.getPhoneNumberTF().sendKeys(utility.readExcelData("Sheet1", 1, 5));
		Thread.sleep(2000);
		addressformpage.getAddAdressBtn().click();	
	}
		
		
		
		
		

}