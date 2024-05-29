package com.shoppersStack.GenericUtility;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility {
	public void selectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element,int value) {
		Select sel=new Select(element);
		sel.selectByIndex(value);
	}
	
	public void selectByVisibleText(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public void deSelectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deSelectByIndex(WebElement element,int value) {
		Select sel=new Select(element);
		sel.deselectByIndex(value);
	}
	
	public void deSelectByVisibleText(WebElement element,String value) {
		Select sel=new Select(element);
		sel.deselectByVisibleText(value);
	}
	
	public void deSelectAll(WebElement element) {
		Select sel=new Select(element);
		sel.deselectAll();
	}
	
	public void getFirstSelectedOption(WebElement element) {
		Select sel=new Select(element);
		sel.getFirstSelectedOption();
	}
	
	public void getAllSelectedOption(WebElement element) {
		Select sel=new Select(element);
		sel.getAllSelectedOptions();
	}
	
	public void isMultiple(WebElement element) {
		Select sel=new Select(element);
		sel.isMultiple();
	}
	
	public void getOptions(WebElement element) {
		Select sel=new Select(element);
		sel.getOptions();
	}

	public void actionMoveToElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void getWebPageScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("");
		FileHandler.copy(temp, dest);
	}
}
