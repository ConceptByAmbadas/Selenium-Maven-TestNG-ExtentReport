package com.info.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.info.TestBase.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends Utility{
	private static WebElement element;
	public WebDriver driver;

	By username = By.id("log");
	By pswd = By.id("pwd");
	By chkLogin = By.id("login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void click_Login() {
		test=report.startTest("Login Test");
		driver.findElement(chkLogin).click();
		Reporter.log("User Click on Login");
		test.log(LogStatus.INFO, "User has click on Login button");
	}

	public void Enter_Password(String psw) {
		try
		{
		test=report.startTest("Enter User password");
		driver.findElement(pswd).sendKeys(psw);
		Reporter.log(psw + "is enter");
		test.log(LogStatus.INFO, "User has enter password As"+psw);
		takeScreenshot(driver);
		
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex.getMessage());
		}
	}

	public void Enter_UserName(String nm) {
		try
		{
			test=report.startTest("Enter User Name");
		if (driver.findElements(username).size() == 1) {
			if (driver.findElement(username).isEnabled()) {
				driver.findElement(username).sendKeys(nm);
				Reporter.log("<font color='green'>" + nm + "is enter");
				test.log(LogStatus.INFO, "User has enter Username As"+nm);
			} else {
				Reporter.log("Username" + nm + "not available");
				Assert.assertFalse(true);
			}
		}
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex.getMessage());
		}
	}

}