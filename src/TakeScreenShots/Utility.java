package TakeScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
	public static  void CaptureScreenShot(WebDriver driver, String ScreenshotsName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			
			FileUtils.copyFile(src, new File("./screenshots/"+ScreenshotsName+".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("The Error message it:"+e.getMessage());
		}
		
	}

}
