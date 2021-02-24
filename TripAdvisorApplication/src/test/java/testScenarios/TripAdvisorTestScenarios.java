package testScenarios;

/** 
 * This code is defined to create Testcases
 * @author Four_0_Four_Finders
 * Date:25/02/2021 
 */

//Import All Necssary Libraries
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

	// Invoking Browser
	@BeforeGroups("Smoke Test One")
	public void driverConfig() {
		browser = prop.getProperty("browser");
		driver = DriverSetup.driverInstantiate(browser);

		report = ExtentReportManager.getReportInstance();

		homePage = PageFactory.initElements(driver, HomePage.class);
		holidayHomes = PageFactory.initElements(driver, HolidayHomesPage.class);
		cruises = PageFactory.initElements(driver, CruisesPage.class);
	}

	// Invoking Excel Sheet In The Program
	@Test(priority = 0, groups = { "Smoke Test One" })
	public void readData() {
		ExcelReadWrite.readexcel();
	}

	// Choosing The Destination from Tripadvisor.in
	@Test(priority = 1, groups = { "Smoke Test One" })
	public void selectDestination() {
		logger = report.createTest("Selecting Destination For Holiday-Home");
		try {
			homePage.holidayHomeButton();
			logger.log(Status.INFO, "Clicking On Holiday-Home");
			homePage.setWhereTo(ExcelReadWrite.data[0]);
			logger.log(Status.INFO, "Giving value for Destination");
			homePage.selectDestination();

			// Taking Scrrenshot of Holiday Homes Page
			try {
				ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.log(Status.INFO, "Choose Destination From Drop-down menu");
			logger.log(Status.PASS, "Data Passed Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Giving value for Check-In Date from calender
	@Test (priority=2, groups= {"Smoke Test One"})
	public void checkInDate() {
		logger = report.createTest("Giving value for Check-In Date");
	try{	
		holidayHomes.checkInDateClick();
		logger.log(Status.INFO, "Clicking On Check-In Calendar");
		holidayHomes.setCheckInDate(ExcelReadWrite.data[1]);
		
		logger.log(Status.INFO, "Selecting Check-In Date");
		logger.log(Status.PASS, "Date has been selected Successfully");
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}	
	}

	// Giving value for Check-Out Date from calender
	@Test (priority =3, groups= {"Smoke Test One"})
	public void checkOutDate() {
		logger = report.createTest("Giving value for Check-Out Date");
	try{
		//holidayHomes.checkOutDateClick();
		holidayHomes.setCheckOutDate(ExcelReadWrite.data[2]);
		logger.log(Status.INFO, "Clicking On Check-Out Calendar");
		logger.log(Status.PASS, "Date has been selected Successfully");
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Giving Value For Guest
	@Test (priority =4, groups= {"Smoke Test One"})
	public void setGuest() {
		
		logger = report.createTest("Giving value for Guest");
	try{
		holidayHomes.guestButton();
		logger.log(Status.INFO, "Adding Guests");
		holidayHomes.addPerson(ExcelReadWrite.data[4]);
		holidayHomes.applyButton();
		logger.log(Status.INFO, "Clicking On Apply Button");
		logger.log(Status.PASS, "Guests added Successfully");
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Sorting The Hotel's Details Based On The Filters Available
	@Test (priority = 5, groups= {"Regression Test One"})
	public void sortBy() {
		logger = report.createTest("Sort Hotel names");
	try{	
		holidayHomes.sortByDropdown();
		logger.log(Status.INFO, "Sort Hotel names from Drop-down");
		holidayHomes.sortByOptions(ExcelReadWrite.data[3]);
		logger.log(Status.INFO, "Selecting the Value for sort");
		logger.log(Status.PASS, "Sorting done Successfully");
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Clicking On The Lift Access Check Box
	@Test (priority = 6, groups= {"Regression Test One"})
	public void liftAccess() {
		logger = report.createTest("Clicking on lift access Check-Box");
	try{	
	
		holidayHomes.showMoreBox();
		logger.log(Status.INFO, "Clicking on Show More");
		holidayHomes.liftAccessCheckbox();
		
        		try {
                              ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
                              e.printStackTrace();
			}
		
		logger.log(Status.INFO, "Checked on Lift access Check box");
		logger.log(Status.PASS, "Data checked Successfully");
	   }catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Fetching Top-3 Hotel Names Based On Filters Applied
	@Test(priority = 7, groups = { "Regression Test One" })
	public void hotelNames() {
		logger = report.createTest("Fetching Top-3 Hotel Names Based on filters");
		try {
			String temp = ExcelReadWrite.data[5].substring(0, 1);
			listSize = Integer.parseInt(temp);

			String[] text = new String[listSize];
			text = holidayHomes.getHotelNames(listSize);

			for (int i = 0; i < text.length; i++) {
				ExcelReadWrite.writeExcel(text[i], 0, i + 1);
			}
			logger.log(Status.INFO, "Top-3 Hotel names have been selected");
			logger.log(Status.PASS, "Top-3 Hotel names have been written Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}

	}

	// Fetching Top-3 Hotel's Total-Price Based On Filters Applied
	@Test(priority = 8, groups = { "Regression Test One" })
	public void totalPrice() {
		logger = report.createTest("Fetching Top-3 Hotel's Total-Price Based on filters");
		try {
			String[] text = new String[listSize];
			text = holidayHomes.getTotalPrice(listSize);

			for (int i = 0; i < text.length; i++) {
				ExcelReadWrite.writeExcel(text[i], 1, i + 1);
			}
			logger.log(Status.INFO, "Top-3 Hotel's Total-Price have been selected");
			logger.log(Status.PASS, "Top-3 Hotel's Total-Price have been written Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Fetching Top-3 Hotel's Price Per Night Based On Filters Applied
	@Test(priority = 9, groups = { "Regression Test One" })
	public void pricePerNight() {
		logger = report.createTest("Fetching Top-3 Hotel's Price Per Night Based on filters");
		try {
			String[] text = new String[listSize];
			text = holidayHomes.getPerNightPrice(listSize);

			// Please check its working or not
			// Screenshot Taken After appling All Filters
			try {
				ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int i = 0; i < text.length; i++) {
				ExcelReadWrite.writeExcel(text[i], 2, i + 1);
			}
			logger.log(Status.INFO, "Top-3 Hotel's Price Per Night have been selected");
			logger.log(Status.PASS, "Top-3 Hotel's Price Per Night have been written Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Clicking On Cruises Menu
	@Test(priority = 10, groups = { "Smoke Test Two" })
	public void cruises() {
		logger = report.createTest("Clicking On Cruises Tab");
		try {
			holidayHomes.cruisesTab();
			logger.log(Status.INFO, "Cruises tab has been clicked");
			logger.log(Status.PASS, "Cruises tab has been clicked Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Selecting Value For Cruise Line
	@Test(priority = 11, groups = { "Smoke Test Two" })
	public void cruiseLine() {
		logger = report.createTest("Selecting Value for Cruise Line");
		try {
			cruises.cruiseLineDropDown();
			logger.log(Status.INFO, "Cruise Line Drop-down has been Visible");
			cruises.cruiseLineDropDownElements(ExcelReadWrite.data[6]);
			logger.log(Status.INFO, "Cruise Line Value has been Selected from drop-down");
			logger.log(Status.PASS, "Cruise Line Value has been Selected from drop-down Successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Selecting Value For Cruise Ship
	@Test(priority = 12, groups = { "Smoke Test Two" })
	public void cruiseShip() {
		logger = report.createTest("Selecting Value for Cruise Ship");
		try {
			cruises.cruiseShipDropDown();
			logger.log(Status.INFO, "Cruise Ship Drop-down has been Visible");
			cruises.cruiseShipDropDownElements(ExcelReadWrite.data[7]);
			logger.log(Status.INFO, "Cruise Ship Value has been Selected from drop-down");
			logger.log(Status.PASS, "Cruise Ship Value has been Selected from drop-down Successfully");
			try {
				ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			cruises.searchCruises();
			logger.log(Status.INFO, "Clicking On Search Button");
			logger.log(Status.PASS, "The Page is loaded Successfully Based on Cruises information");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Moving To The New Window
	@Test(priority = 13, groups = { "Smoke Test Two" })
	public void changeWindow() {
		logger = report.createTest("Moving To the new Window");
		try {
			cruises.changeWindowHandle();

			try {
				ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.log(Status.INFO, "A new Window opened");
			logger.log(Status.PASS, "A new window has been opened successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Fetching The Value Of Passenger & Crew
	@Test(priority = 14, groups = { "Regression Test Two" })
	public void PassengerCrewValue() {

		logger = report.createTest("Fetching the value of Passenger & Crew");
		try {
			int i = 0;
			cruises.getpassengerAndCrew();
			ExcelReadWrite.writeExcel(CruisesPage.passenger, 3, i + 1);
			ExcelReadWrite.writeExcel(CruisesPage.crew, 4, i + 1);
			logger.log(Status.INFO, "Passenger & Crew's value have been fetched");
			logger.log(Status.PASS, "Passenger & Crew's value have been written successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Fetching The Value Of Launched Year
	@Test(priority = 15, groups = { "Regression Test Two" })
	public void launchedYearValue() {

		logger = report.createTest("Fetching the value of Launched Year");
		try {
			String text = cruises.setLaunchedYear();
			ExcelReadWrite.writeExcel(text, 5, 1);

			try {
				ScreenShot.takeSnapShot(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.log(Status.INFO, "Launched Year value has been fetched");
			logger.log(Status.PASS, "Launched Year value has been written successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Fetching The Value Of Languages
	@Test(priority = 16, groups = { "Regression Test Two" })
	public void languageValue() {
		logger = report.createTest("Fetching the value of Languages");
		try {
			languages = cruises.getLanguages();

			for (int i = 1; i < languages.length; i++) {
				ExcelReadWrite.writeExcel(languages[i], 6, i);
			}
			logger.log(Status.INFO, "Languages value have been fetched");
			logger.log(Status.PASS, "Languages value have been written successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
	}

	// Closing The Browser
	@AfterGroups("Regression Test Two")
	public void closeBrowser() {
		logger = report.createTest("Closing the Browser");
		try {
			DriverSetup.driverClose();
			logger.log(Status.PASS, "Browser has been closed successfully");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}
		report.flush();
	}

}
