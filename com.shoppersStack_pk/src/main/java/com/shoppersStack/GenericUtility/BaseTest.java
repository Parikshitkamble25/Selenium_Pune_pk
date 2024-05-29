package com.shoppersStack.GenericUtility;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shoppersStack.Pom.AddressForm_Page;
import com.shoppersStack.Pom.HomePage;
import com.shoppersStack.Pom.LoginPage;
import com.shoppersStack.Pom.Welcome_Page;

public class BaseTest {
	public WebDriver driver;
	public static WebDriver listenersDriver;
	public File_utility utility=new File_utility();
	public Webdriver_utility webUtility=new Webdriver_utility(); 
	public Welcome_Page welcomePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public AddressForm_Page addressformpage;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest Test;
	public Java_Utility javautil=new Java_Utility();

	
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
		spark=new ExtentSparkReporter(Framework_constants.reportPath+javautil.localDateTime()+".html");
		 ExtentReports reprt = new ExtentReports();
		reprt.attachReporter(spark);
		 Test = reprt.createTest("Demo");


	}
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");
		
		// String browser =file.readPropertyData("browser");
		// String url=file.readPropertyData("url");.
		
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		
		//String browser = "chrome";
		//String url=utility.readPropertyData("url");
		if(browser.contains("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.contains("firefox"))
		{

			driver= new FirefoxDriver();
		}
		else if (browser.contains("edge")) 
		{
			driver= new EdgeDriver();

		}
		else {
			System.out.println("Enter valid browser name");
		}
		listenersDriver = driver;
		welcomePage=new Welcome_Page(driver);
		homePage= new HomePage(driver);
		loginPage=new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
		

	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
		welcomePage.getLoginBtn().click();
		loginPage.getEmailTB().sendKeys(utility.readPropertyData("username"));
		loginPage.getPasswordTB().sendKeys(utility.readPropertyData("password"));
		loginPage.getLoginBtn().click();
		
		System.out.println("@BeforMethod");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("@AfterMethod");
		
		Thread.sleep(5000);
		homePage.getAccountSettingBtn().click();
		homePage.getLogoutBtn().click();
		}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}
	
	}
