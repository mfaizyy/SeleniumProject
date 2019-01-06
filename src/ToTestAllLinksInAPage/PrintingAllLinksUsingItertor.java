//This program prints all the links available in a page by 
//using the java Iterator
package ToTestAllLinksInAPage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrintingAllLinksUsingItertor
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
        
        //printing the size of page links
        System.out.println("The Number of Links Available on the page "+pageLinks.size());
        
        Iterator<WebElement> itr = pageLinks.iterator();
        int i = 0;
        //Loops untill it has next element
        while(itr.hasNext())
        {
        	System.out.println(++i +" : "+itr.next().getText());//printing the links with serial no by using i++
        	//i++;
        }  
		
	}
}