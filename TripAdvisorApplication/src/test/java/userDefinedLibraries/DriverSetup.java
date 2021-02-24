package userDefinedLibraries;

//Import all Necessary Libraries
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//To Instantiate Driver
public class DriverSetup {

	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	public static WebDriver driver;
	public static String exePath;
	public static String url = prop.getProperty("websiteURL");
	public static String browsertype;

	public static WebDriver driverInstantiate(String browser) {
		browsertype = browser;

		// instantiate chrome browser
		if (browsertype.equalsIgnoreCase("chrome")) {
			exePath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		}

		// instantiate firefox browser
		else if (browser.equalsIgnoreCase("firefox")) {
			exePath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();
		}

		// Maximize the Window
		driver.manage().window().maximize();
		// Implement Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Fetch the url
		driver.get(url);
		// Delete all cookies
		driver.manage().deleteAllCookies();

		return driver;

	}

	public static void driverClose() {
		driver.quit();
	}

}
