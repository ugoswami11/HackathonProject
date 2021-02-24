package testObjectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//To perform all the functionalities of the Cruises page in Tripadvisor.in
public class CruisesPage {

	final WebDriver driver;
	public static WebDriverWait wait;
	public static String passenger = "", crew = "", launchedYearText = "";

	// To locate the Cruise Line dropdown button
	@FindBy(how = How.XPATH, using = "//*[@id='cruise_line_dropdown']")
	public WebElement cruiseLine;

	// To locate the all the elements in Cruise Line dropdown list
	@FindBy(how = How.XPATH, using = "//div[@id='component_1']/div/div[3]/div/div[1]/div/div[2]/div")
	public List<WebElement> cruiseLineElements;

	// To locate the Cruise Ship dropdown button
	@FindBy(how = How.XPATH, using = "//div[@id='component_1']/div/div[3]/div/div[2]")
	public WebElement cruiseShip;

	// To locate the all the elements in Cruise Ship dropdown list
	@FindBy(how = How.XPATH, using = "//div[@class='CfqcQ1jD option']")
	public List<WebElement> cruiseShipElements;

	// To locate the Search button
	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	public WebElement searchCruises;

	// To locate the Passenger and Crew textbox
	@FindBy(how = How.XPATH, using = "//*[@id='ship_overview']//div[1]/div[1]/div[2]/div[1]")
	public WebElement passengersAndCrew;

	// To locate the Launched year textbox
	@FindBy(how = How.XPATH, using = "//div[@class='_30ZCn9lR']/div[4]")
	public WebElement launchedYear;

	// To locate the all the elements for available languages
	@FindBy(how = How.XPATH, using = "//label[@class='bUKZfPPw']")
	public List<WebElement> languageElements;

	// To implement wait
	public CruisesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	// To click on the Cruise Line dropdown button
	public void cruiseLineDropDown() {
		cruiseLine.click();
	}

	// To select the input from the Cruise Line dropdown options
	public void cruiseLineDropDownElements(String cruiseLineValue) {

		wait.until(ExpectedConditions.visibilityOfAllElements(cruiseLineElements));

		for (WebElement cruiseElements : cruiseLineElements) {
			if (cruiseLineValue.equals(cruiseElements.getText())) {
				cruiseElements.click();
				break;
			}
		}
	}

	// To click on the Cruise Ship dropdown button
	public void cruiseShipDropDown() {
		cruiseShip.click();
	}

	// To select the input from the Cruise Ship dropdown options
	public void cruiseShipDropDownElements(String cruiseShipValue) {

		wait.until(ExpectedConditions.visibilityOfAllElements(cruiseShipElements));

		for (WebElement cruiseShipElement : cruiseShipElements) {
			if (cruiseShipValue.equals(cruiseShipElement.getText())) {
				cruiseShipElement.click();
				break;
			}
		}
	}

	// To click on the Search button
	public void searchCruises() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchCruises.click();
	}

	// To get the number of passengers and crew members for the selected cruise
	public void getpassengerAndCrew() {
		String passengerNcrew = passengersAndCrew.getText();

		passenger = passenger + passengerNcrew.substring(12, 15);

		crew = crew + passengerNcrew.substring(28, passengerNcrew.length());
	}

	// To get the launch year for the selected cruise
	public String setLaunchedYear() {
		String launchYearText = launchedYear.getText();

		launchedYearText = launchedYearText
				+ launchYearText.substring((launchYearText.length() - 7), (launchYearText.length()));
		return launchedYearText;
	}

	// To get the languages available for the selected cruise
	public String[] getLanguages() {
		int size = languageElements.size();
		String s;
		String[] languages = new String[size];
		for (int i = 0; i < size; i++) {
			s = languageElements.get(i).getText();
			languages[i] = s.substring(0, (s.length() - 3));
		}
		return languages;
	}

	// To perfom window handling
	public void changeWindowHandle() {
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
			}

		}
	}
}
