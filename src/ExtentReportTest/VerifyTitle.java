package ExtentReportTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TakeScreenShots.Utility2;

public class VerifyTitle 
{
 
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
 
 
@Test
public void verifyBlogTitle()
	{
		report=new ExtentReports("C:\\LearnAutomation.html");
		 
		logger=report.startTest("VerifyBlogTitle");
		
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		 
		driver=new FirefoxDriver();
		 
		driver.manage().window().maximize();
		 
		logger.log(LogStatus.INFO, "Browser started ");
		 
		driver.get("http://www.learn-automation.com");
		 
		logger.log(LogStatus.INFO, "Application is up and running");
		 
		String title=driver.getTitle();
		 
		Assert.assertTrue(title.contains("Google")); 
		
		logger.log(LogStatus.PASS, "Title verified");
	}
 
 
@AfterMethod
public void tearDown(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
 
		String screenshot_path=Utility2.CaptureScreenShot(driver, result.getName());
		String image= logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.FAIL, "Title verification", image);
 
 
	}
 
	report.endTest(logger);
	report.flush();
 
	driver.get("C:\\LearnAutomation.html");
}
 
 
}