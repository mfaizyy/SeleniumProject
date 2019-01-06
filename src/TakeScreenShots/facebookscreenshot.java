package TakeScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class facebookscreenshot {
	
	WebDriver driver;
	
	@Test
	public void FacebookScreenshot() throws Exception{
		
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		//driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./screenshots/facebook.png"));
		
		
	}

}
