package com.info.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.info.TestBase.Utility;
import com.info.pages.HomeLoan;
import com.relevantcodes.extentreports.LogStatus;
public class MainTest extends Utility {
	
	public WebDriver driver;
	
	HomeLoan loan;
	//Enquiry enquiry;
	
	@BeforeSuite
	public void setup()
	{
		driver=new FirefoxDriver();
		PageFactory.initElements(driver,HomeLoan.class);
	
	}
	@BeforeTest
	public void launchApp()
	{
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.propchilli.com");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void to_Validate_HomeLoanDetails()
	{
		//test=report.startTest("to_FIll_HomeLoan_Details");
		//test.log(LogStatus.INFO, "Started Test");
		loan.to_Fill_Homeloan_Details("Pravin", "9856859854", "xyz@gamil.com");
		
	}
	@AfterTest
	public void closeTest()
	{
		//driver.close();
		//driver.quit();
	}
	
	
	

}
