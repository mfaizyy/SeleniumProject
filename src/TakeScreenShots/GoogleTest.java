package TakeScreenShots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		//driver.manage().window().maximize();
	}
	
	@Test
	public void GoogleScreenShots()
	{
		driver.get("https://www.google.com");
		Utility.CaptureScreenShot(driver, "GoogleOpned");
		driver.findElement(By.name("q")).sendKeys("faizan");
		Utility.CaptureScreenShot(driver, "FaizanTyped");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
