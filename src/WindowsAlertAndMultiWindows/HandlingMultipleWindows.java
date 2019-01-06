//This program handles all opened windows/tab in a browser and close the child window and switching to parent window

package WindowsAlertAndMultiWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingMultipleWindows{
	public static void main(String[] args) {
		
		//Browser setting up
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32_2.40\\chromedriver.exe\\");
		
        //System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        //WebDriver driver = new FirefoxDriver();
        
        //maximizing the window
        //driver.manage().window().maximize();
        
        driver.get("http://demo.guru99.com/popup.php");
        
        //finding the click here button
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        
        //main window handle
        String parentWindow = driver.getWindowHandle();
        
        //printing the parent window id
        System.out.println("Parentwindow id is: "+parentWindow);
        
        //Handling child window
        Set<String> allWindows = driver.getWindowHandles();
        
        System.out.println("allwindows count: "+allWindows.size());
        
        //int cnt = allWindows.size();
        Iterator<String> i1 = allWindows.iterator();
        
        while(i1.hasNext())
        {
        	String childWindow = i1.next();
        	if(!parentWindow.equalsIgnoreCase(childWindow))
        	{
        		//Switching to the child window
        		driver.switchTo().window(childWindow);
        		
        		//Entering test into text box
        		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("gaurav.3n@gmail.com");
        		
        		//clicking on submit button
        		driver.findElement(By.name("btnLogin")).click();
        		
        		///closing the child window
        		driver.close();
        	}
        }
        
        //switching to main window
        System.out.println("switching main window");
        driver.switchTo().window(parentWindow);
    	
	}

}
