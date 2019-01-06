package newproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo 
{
	public static void main(String[] args) 
	
	{
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faizy\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faizy\\Downloads\\Compressed\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//button[Text()='Automation Tools']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		List<WebElement> links = (List<WebElement>) driver.findElement(By.xpath("//button[Text()='Automation Tools']//a"));
		
		int total_cnt = links.size();
		
		for(int i =0; i<total_cnt; i++)
		{
			WebElement element = links.get(i);
			String text = element.getAttribute("innerHTML");
			System.out.println("Links text are: "+text);
			if (text.equalsIgnoreCase("Appium"))
				{
					element.click();
					break;
				}
		}
	}
}
