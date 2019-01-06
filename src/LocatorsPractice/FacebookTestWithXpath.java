package LocatorsPractice;

//working Program
// This program is to show using xpath for facebook only
//The syntex for xpath is //tagName[@attribute=value'']

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTestWithXpath {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-2.38_win32\\chromedriver.exe"); // latest chrome driver 2.38
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
