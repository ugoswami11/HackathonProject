package testScenarios;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import testObjectRepository.CruisesPage;
import testObjectRepository.HolidayHomesPage;
import testObjectRepository.HomePage;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelReadWrite;
import userDefinedLibraries.GetPropertiesFile;

import userDefinedLibraries.ExtentReportManager;
import userDefinedLibraries.FailReport;
import userDefinedLibraries.ScreenShot;

public class TripAdvisorTestScenarios {
	
	public static HomePage homePage;
	public static HolidayHomesPage holidayHomes;
	public static CruisesPage cruises;
	public static WebDriver driver;
	public static String browser;
	public static int listSize;
	public static String[] languages;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeGroups("Smoke Test One")
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.driverInstantiate(browser);
                
		report = ExtentReportManager.getReportInstance();
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		holidayHomes = PageFactory.initElements(driver, HolidayHomesPage.class);
		cruises = PageFactory.initElements(driver, CruisesPage.class);
	}
	
	@Test (priority=0, groups= {"Smoke Test One"})
	public void readData() {
		ExcelReadWrite.readexcel();
	}
	
	@Test (priority=1, groups= {"Smoke Test One"})
	public void selectDestination() {
		logger = report.createTest("Selecting Destination For Holiday-Home");
	try{	
		homePage.holidayHomeButton();
		logger.log(Status.INFO, "Clicking On Holiday-Home");
		homePage.setWhereTo(ExcelReadWrite.data[0]);
		logger.log(Status.INFO, "Giving value for Destination");
		homePage.selectDestination();
		
		
			try {
                              ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
                              e.printStackTrace();
			}
		
		logger.log(Status.INFO, "Choose Destination From Drop-down menu");
		logger.log(Status.PASS, "Data Passed Successfully");
		
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}
	
	@Test (priority=2, groups= {"Smoke Test One"})
	public void checkInDate() {
		logger = report.createTest("Giving value for Check-In Date");
	try{	
		holidayHomes.checkInDateClick();
		logger.log(Status.INFO, "Clicking On Check-In Calendar");
		holidayHomes.setCheckInDate(ExcelReadWrite.data[1]);
		
		logger.log(Status.INFO, "Selecting Check-In Date");
		logger.log(Status.PASS, "Date has been selected Successfully")
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}	
	}
	
	@Test (priority =3, groups= {"Smoke Test One"})
	public void checkOutDate() {
		logger = report.createTest("Giving value for Check-Out Date");
	try{
		//holidayHomes.checkOutDateClick();
		holidayHomes.setCheckOutDate(ExcelReadWrite.data[2]);
		logger.log(Status.INFO, "Clicking On Check-Out Calendar");
		logger.log(Status.PASS, "Date has been selected Successfully")
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}
	
	@Test (priority =4, groups= {"Smoke Test One"})
	public void setGuest() {
		
		logger = report.createTest("Giving value for Guest");
	try{
		holidayHomes.guestButton();
		logger.log(Status.INFO, "Adding Guests");
		holidayHomes.addPerson(ExcelReadWrite.data[4]);
		holidayHomes.applyButton();
		logger.log(Status.INFO, "Clicking On Apply Button");
		logger.log(Status.PASS, "Guests added Successfully")
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}
	
	@Test (priority = 5, groups= {"Regression Test One"})
	public void sortBy() {
		logger = report.createTest("Giving value for Guest");
	try{	
		holidayHomes.sortByDropdown();
		holidayHomes.sortByOptions(ExcelReadWrite.data[3]);
	}
	
	@Test (priority = 6, groups= {"Regression Test One"})
	public void liftAccess() {
		holidayHomes.showMoreBox();
		holidayHomes.liftAccessCheckbox();
	}
	
	@Test (priority = 7, groups= {"Regression Test One"})
	public void hotelNames() {
		
		String temp = ExcelReadWrite.data[5].substring(0, 1);
		listSize = Integer.parseInt(temp);
		
		String[] text = new String[listSize];
		text =holidayHomes.getHotelNames(listSize);
		
		for(int i=0;i<text.length;i++) {
			System.out.println(text[i]);
		}
	}
	
	@Test (priority = 8, groups= {"Regression Test One"})
	public void totalPrice() {
		String[] text = new String[listSize];
		text = holidayHomes.getTotalPrice(listSize);
		
		for(int i=0;i<text.length;i++) {
			System.out.println(text[i]);
		}
	}
	
	@Test (priority =9, groups= {"Regression Test One"})
	public void pricePerNight() {
		String[] text = new String[listSize];
		text = holidayHomes.getPerNightPrice(listSize);
		
		for(int i=0;i<text.length;i++) {
			System.out.println(text[i]);
		}
	}
	
	@Test (priority= 10, groups= {"Smoke Test Two"})
	public void cruises() {
		holidayHomes.cruisesTab();
	}
	
	@Test (priority =11, groups= {"Smoke Test Two"})
	public void cruiseLine() {
		cruises.cruiseLineDropDown();
		cruises.cruiseLineDropDownElements(ExcelReadWrite.data[6]);
	}	
	
	@Test (priority = 12, groups= {"Smoke Test Two"})
	public void cruiseShip() {
		cruises.cruiseShipDropDown();
		cruises.cruiseShipDropDownElements(ExcelReadWrite.data[7]);
		cruises.searchCruises();
	}
	
	@Test (priority = 13, groups= {"Smoke Test Two"})
	public void changeWindow() {
		cruises.changeWindowHandle();
	}
	
	@Test (priority = 14, groups= {"Regression Test Two"})
	public void PassengerCrewValue() {
		
		cruises.getpassengerAndCrew();
		System.out.println(cruises.passenger+"\t"+cruises.crew);
	}
	
	@Test (priority = 15, groups= {"Regression Test Two"})
	public void launchedYearValue() {
		String text = cruises.setLaunchedYear();
		System.out.println(text);
	}
	
	@Test(priority = 16, groups= {"Regression Test Two"})
	public void languageValue() {
		languages = cruises.getLanguages();
		
		for(int i=0;i<languages.length;i++) {
			System.out.println(languages[i]);
		}
	}
	
	@AfterGroups ("Regression Test Two")
	public void closeBrowser() {
		DriverSetup.driverClose();
	}
	
}
