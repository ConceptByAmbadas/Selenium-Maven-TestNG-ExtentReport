package com.info.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.info.TestBase.Utility;
import com.info.pages.HomePage;
import com.info.pages.LoginPage;
public class MainTest extends Utility {
	
	static WebDriver driver;
	
	HomePage hp;
	LoginPage Lp;
	
	@BeforeSuite
	public void setup()
	{
		driver=new FirefoxDriver();
		//System.setProperty(ESCAPE_PROPERTY "false");
	}
	@BeforeTest
	public void launchApp()
	{
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void run()
	{
		 hp=new HomePage(driver);
		 Lp=new LoginPage(driver);
	
		driver.findElement(By.id("account")).click();
		//hp.Lnk_My_Account();
		Lp.Enter_UserName("pravin");
		Lp.Enter_Password("Test123");
		Lp.click_Login();
		//hp.chk_Logout();
	}
	@AfterTest
	public void closeTest()
	{
		//driver.close();
		//driver.quit();
	}
	
	
	

}
