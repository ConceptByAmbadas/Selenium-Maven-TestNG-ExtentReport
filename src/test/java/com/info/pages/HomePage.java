package com.info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.info.TestBase.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Utility{

	public WebElement element;
	 WebDriver driver;
	  
	 By acc=By.id("account");
	 By logout=By.id("account_logout");
	
	 public HomePage(WebDriver Driver)
	 {
		 this.driver=driver;
	 }
	/*@FindBy(name="q")
	public WebElement txtsearch;
	@FindBy(xpath=("//*[@id='one']"))
	public WebElement txtid;*/
	 public  void Lnk_My_Account()
	 {
		test=report.startTest("Click On My Account");
		 driver.findElement(acc).click();
		test.log(LogStatus.INFO, "User has Click on My Account");
		takeScreenshot(driver);
	 }
	 public void chk_Logout()
	 {
		 driver.findElement(logout).click();
		 test.log(LogStatus.INFO, "User has click on Logout");
		
	 }

}
