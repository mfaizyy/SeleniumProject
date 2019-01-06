package LocatorsPractice;
//working program
//This program is to show the uses of xpath at salesforce site

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceXpath {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-2.38_win32\\chromedriver.exe"); //latest chrome driver 2.38
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345");
		driver.findElement(By.id("Login")).click();
	}

}
