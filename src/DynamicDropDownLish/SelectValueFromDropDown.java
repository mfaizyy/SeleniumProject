package DynamicDropDownLish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropDown {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");					
        WebDriver driver = new FirefoxDriver();	
		driver.get("http://www.spicejet.com");
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")));
		s.selectByValue("GOI");
		
	}

}
