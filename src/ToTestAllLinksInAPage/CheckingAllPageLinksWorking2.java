//This Program checks all links are working or not and print them without creating any method
package ToTestAllLinksInAPage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckingAllPageLinksWorking2 
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
	        System.out.println("The Number of Links Available on the page is: "+pageLinks.size());
	        int i = 0;
	        for(i=0; i<pageLinks.size(); i++)
	        {
	        	WebElement ele = pageLinks.get(i);
	        	String url = ele.getAttribute("href");
		        	try 
		    		{
		    			URL linkurl = new URL(url);
		    			
		    			HttpURLConnection httpURLConnect=(HttpURLConnection)urll.openConnection();
		    			
		    			//connecting with url and sending request
		    			httpURLConnect.connect();
		    			
		    			if(httpURLConnect.getResponseCode()==200)
		    			{
		    				System.out.println(i+":"+linkurl +" "+httpURLConnect.getResponseMessage());
		    			}
		    			if(httpURLConnect.getResponseCode()==httpURLConnect.HTTP_NOT_FOUND)
		    			{
		    				System.out.println(i+":"+linkurl+" "+httpURLConnect.getResponseMessage()+" "+httpURLConnect.HTTP_NOT_FOUND);
		    			}
		    		}
		    		catch(Exception e)
		    		{
		    		
		    		}
	    	}
	}
}