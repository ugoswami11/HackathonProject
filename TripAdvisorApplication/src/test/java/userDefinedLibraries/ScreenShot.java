package userDefinedLibraries;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static String screenShotTC(WebDriver ldriver){
		File sourceFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(
				System.getProperty("user.dir") + "\\screenshot\\" + System.currentTimeMillis() + ".png");
		try { 
			//copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return destFile.getPath();
	}
}
