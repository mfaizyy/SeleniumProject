//This program printing the page links by using the simple loop
package ToTestAllLinksInAPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrintAllLinksUsingSimpleLoop 
{
	public static void main(String[] args) 
	{
		//URL that needs to be open
		String baseUrl = "https://www.google.com";
		
		//Browser setting up
        //System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32_2.40\\chromedriver.exe\\");	
        System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        
        //WebDriver driver = new ChromeDriver();	
        WebDriver driver = new FirefoxDriver();
        
       //Maximizing the browser
        driver.manage().window().maximize();
        
        //Opening the specified URl
        driver.get(baseUrl);
        
        //storing all the page links in pageLinks object
        List<WebElement> pageLinks = driver.findElements(By.tagName("a"));
        
        //printing the number of page links
        System.out.println("The Number of Links Available on the page "+pageLinks.size());
        
        int ele = pageLinks.size();
        
        for(int i=0; i<ele; i++)
        {
        	//i+ is printing the serial number before each link, like 0 : Gmail
        	System.out.println(i+" : "+pageLinks.get(i).getText()); //i is just printing the serial no before each link
        }
		
	}
}