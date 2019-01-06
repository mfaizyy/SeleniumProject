package FindingTheBrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingTheBrokenLinks {
	
	private static WebDriver drive = null;
	
	public static void main(String[] args) 
	{
		String homepage = "http://www.zlti.com";
		String url="";
		HttpURLConnection huc = null;
		int respCode = 200;
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32_2.40\\chromedriver.exe\\");
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        //WebDriver driver = new ChromeDriver();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get(homepage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext())
        {
        	it.next().getAttribute("href");
        	System.out.println(url);
        	if(url==null || url.isEmpty())
        	{
        		System.out.println("URL is not configured or it is empty");
        		continue;
        	}
        	if(!url.startsWith(homepage))
        	{
        		System.out.println("URL belongs to another domain");
        		continue;
        	}
        	try
        	{
        		huc=(HttpURLConnection)(new URL(url).openConnection());
        		huc.setRequestMethod("HEAD");
        		huc.connect();
        		respCode=huc.getResponseCode();
        		if(respCode>=400)
        		{
        			System.out.println(url+"url is broken");
        		}
        		else
        		{
        			System.out.println(url+"url is valid");
        		}
        	} catch (MalformedURLException e)
        	{
        		e.printStackTrace();
        	}catch (IOException e) 
        	{
                // TODO Auto-generated catch block
                e.printStackTrace();
        	}
        	
        }
		
		
	}

}
