package com.info.TestBase;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {

	public static String dest;
	public static String time;
	public static ExtentReports report;
	public static ExtentTest test;
	WebDriver driver;
	
	public static String takeScreenshot(WebDriver driver) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
			time = dateFormat.format(date);
			System.out.println("Time is" + time);
			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);

			dest = "E:\\StudyWorkpace\\TestNG_ExtentReport_Maven\\Screenshot\\" + time + ".png"; 
			File destination = new File(dest);
			FileUtils.copyFile(src, destination);
			System.out.println("image destination" + dest);
			System.out.println("Screen shot taken");

			// return dest;
		} catch (Exception ex) {
			System.out.println("Screenshot error is" + ex.getMessage());
		}
		return dest;
	}
	
	
	@BeforeSuite
	public void Reportsetup()
	{
		try
		{
			//report=new ExtentReports("E://Reports//Test"+System.currentTimeMillis()+".html",true);
			report=new ExtentReports("E://Reports//Test.html",true);
			//report=new ExtentReports("E://StudyWorkpace//ExtentReport//Report"+System.currentTimeMillis()+".html",true);
			report.addSystemInfo("HostName", "Pravin")
			.addSystemInfo("Environment", "SIT")
			.addSystemInfo("User","Ambadas")
			.addSystemInfo("Project Name", "Propchilli.com");
			//report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

			//report.setSystemInfo("HostName", "Pravin").addSystemInfo("Environment", "SIT").addSystemInfo("User", "Ambadas");	
		}
		catch(Exception ex)
		{
			System.out.println("Issue is"+ex.getMessage());
		}
	}
	@AfterMethod
	public void getReport(ITestResult result) {
		try {
			String screnshotpath = takeScreenshot(driver);
			if (result.getStatus() == ITestResult.FAILURE) {

				// String info=result.getThrowable();
				test.log(LogStatus.FAIL, result.getThrowable());
				test.log(LogStatus.FAIL, test.addScreenCapture(screnshotpath));
				test.log(LogStatus.FAIL, "Test Case Fail is:- "+result.getName());

				//test.addScreenCaptureFromPath("please refer below screennshot",screnshotpath);

			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(LogStatus.PASS, "Test Case pass is:- "+result.getName());
				test.log(LogStatus.PASS, "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				test.log(LogStatus.SKIP, "test Case skip is:- "+result.getName());
			}
			else if(result.getStatus()==ITestResult.STARTED)
			{test.log(LogStatus.INFO, "Test Case started");

			}
			report.endTest(test);

		} catch (Exception es) {
			System.out.println(" Report genration Excepion is:- " + es.getMessage());
		}
	}
	@AfterTest
	public void endTest()
	{
	
		report.flush();
		report.close();
	}

	/*@AfterMethod
	public void printReport(ITestResult result)
	{
		System.out.println("In Get method"+result);
		getReport(result);
	}*/

}
