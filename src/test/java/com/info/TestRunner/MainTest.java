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
import com.info.pages.Enquiry;
import com.info.pages.HomeLoan;
import com.info.pages.Show;
import com.relevantcodes.extentreports.LogStatus;
public class MainTest extends Utility {

	public WebDriver driver;

	HomeLoan loan;
	Enquiry enquiry;

	@BeforeSuite
	public void setup()
	{
		driver=new FirefoxDriver();
		loan=PageFactory.initElements(driver,HomeLoan.class);
		enquiry=PageFactory.initElements(driver, Enquiry.class);

	}
	@BeforeTest
	public void launchApp()
	{
		driver.manage().timeouts().pageLoadTimeout(190, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.get("http://www.propchilli.com");
		driver.manage().window().maximize();

	}

	@Test
	public void to_Validate_HomeLoanDetails()
	{
		test=report.startTest("To_Fill_HomeLoan_Details");
		test.log(LogStatus.INFO, "Test Started:-"+test.getStartedTime());
		loan.to_Fill_Homeloan_Details("Pravin", "9856859854", "xyz@gamil.com", "Private", "HDFC Bank");
	}
	@Test(priority=1)
	public void to_Validate_Enquiry_Form()
	{
		test=report.startTest("To_Fill_EnquiryForm");
		test.log(LogStatus.INFO, "Test Started:-"+test.getStartedTime());
		enquiry.fill_Enquiry_form("Pravin", "pravin@gmail.com", "9123454332", "Looking for 2 BHK");
	}
	@AfterTest
	public void closeTest()
	{
		//driver.close();
		//driver.quit();
	}




}
