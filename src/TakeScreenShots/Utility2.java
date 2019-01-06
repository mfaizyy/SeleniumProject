package TakeScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility2 
{
	public static String CaptureScreenShot(WebDriver driver, String ScreenshotsName)
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = "D:\\Workspace\\SeleniumProject\\screenshots"+ScreenshotsName+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("screenshottaken");
		
		return dest;	
		} 
		catch (IOException e) 
		{
			System.out.println("The Error message it:"+e.getMessage());
			return e.getMessage();
		}
		
	}

}
