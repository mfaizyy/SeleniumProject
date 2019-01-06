package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public String driverpath = "D:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe";
	public WebDriver driver;
	
	@Test
	public void VerifyHomePageTitle()
	{
		System.out.println("Launching the browser");
		System.setProperty("webdriver.gecko.driver",driverpath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		String expectedTitles = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitles, actualTitle);
		driver.close();
	}
	
}
