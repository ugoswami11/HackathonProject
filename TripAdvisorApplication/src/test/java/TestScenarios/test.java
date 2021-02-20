package TestScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import UserDefinedLibraries.DriverSetup;
import UserDefinedLibraries.GetPropertiesFile;

public class test {
	
	public static WebDriver driver;
	public static String browser;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.driverInstantiate(browser);
	}
	
	
}
