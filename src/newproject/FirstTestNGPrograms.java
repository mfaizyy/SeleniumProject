package newproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGPrograms {
	
	public String url= "www.facebook.com";
	String driverPath = "D:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	public WebDriver driver;
	
	@Test
	public void verifyHomePageTitle(){
		System.out.println("Launching the browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(url);
		String expectedTitle="Go to Facebook home";
		String actualTitle = driver.getTitle();
		System.out.println("actualTitleis "+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();	
		
	}

}
