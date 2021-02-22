package TestScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestObjectRepository.CruisesPage;
import TestObjectRepository.HolidayHomesPage;
import TestObjectRepository.HomePage;
import UserDefinedLibraries.DriverSetup;
import UserDefinedLibraries.GetPropertiesFile;

public class test {
	
	public static HomePage homePage;
	public static HolidayHomesPage holidayHomes;
	public static CruisesPage cruises;
	public static WebDriver driver;
	public static String browser;
	public static String[] languages;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	
	@BeforeTest
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.driverInstantiate(browser);

		homePage = PageFactory.initElements(driver, HomePage.class);
		holidayHomes = PageFactory.initElements(driver, HolidayHomesPage.class);
		cruises = PageFactory.initElements(driver, CruisesPage.class);
	}
	
	@Test (priority=1)
	public void selectDestination() {
		homePage.holidayHomeButton();
		homePage.setWhereTo("Nairobi");
		homePage.selectDestination();
	}
	
	@Test (priority=2)
	public void checkInDate() {
		holidayHomes.checkInDateClick();
		holidayHomes.setCheckInDate("15/12/2021");
	}
	
	@Test (priority =3)
	public void checkOutDate() {
		//holidayHomes.checkOutDateClick();
		holidayHomes.setCheckOutDate("20/12/2021");
	}
	
	@Test (priority =4)
	public void setGuest() {
		holidayHomes.guestButton();
		holidayHomes.addPerson("4");
		holidayHomes.applyButton();
	}
	
	@Test (priority = 5)
	public void sortBy() {
		holidayHomes.sortByDropdown();
		holidayHomes.sortByOptions();
	}
	
	@Test (priority = 6)
	public void liftAccess() {
		holidayHomes.showMoreBox();
		holidayHomes.liftAccessCheckbox();
	}
	
	@Test (priority= 7)
	public void cruises() {
		holidayHomes.cruisesTab();
	}
	
	@Test (priority =8)
	public void cruiseLine() {
		cruises.cruiseLineDropDown();
		cruises.cruiseLineDropDownElements("A-ROSA Cruises");
	}	
	
	@Test (priority = 9)
	public void cruiseShip() {
		cruises.cruiseShipDropDown();
		cruises.cruiseShipDropDownElements("Bella");
		cruises.searchCruises();
	}
	
	@Test (priority = 10)
	public void changeWindow() {
		cruises.changeWindowHandle();
	}
	
	@Test (priority = 11)
	public void PassengerCrewValue() {
		
		cruises.getpassengerAndCrew();
		System.out.println(cruises.passenger+"\t"+cruises.crew);
	}
	
	@Test (priority = 12)
	public void launchedYearValue() {
		String text = cruises.setLaunchedYear();
		System.out.println(text);
	}
	
	@Test(priority = 13)
	public void languageValue() {
		languages = cruises.getLanguages();
		
		for(int i=0;i<languages.length;i++) {
			System.out.println(languages[i]);
		}
	}
	
}
