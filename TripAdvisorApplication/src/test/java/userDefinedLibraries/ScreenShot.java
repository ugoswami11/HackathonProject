package userDefinedLibraries;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	/**
	 * **************************
	 * CAPTURE SCREENSHOT 
	 * **************************
	 */
	
	public static void takeSnapShot(WebDriver webdriver) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();
		TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + "\\screenshot\\"
							+ dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static String screenShotTC(WebDriver ldriver){
		File sourceFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(
				System.getProperty("user.dir") + "\\FailScreenshot\\" + System.currentTimeMillis() + ".png");
		try { 
			//copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return destFile.getPath();
	}
}
