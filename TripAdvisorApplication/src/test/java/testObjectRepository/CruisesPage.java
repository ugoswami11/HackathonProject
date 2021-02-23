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

public class CruisesPage {

	final WebDriver driver;
	public static WebDriverWait wait;
	public static String passenger="", crew="", launchedYearText="";

	@FindBy(how = How.XPATH, using = "//*[@id='cruise_line_dropdown']")
	public WebElement cruiseLine;

	@FindBy(how = How.XPATH, using = "//div[@id='component_1']/div/div[3]/div/div[1]/div/div[2]/div")
	public List<WebElement> cruiseLineElements;

	@FindBy(how = How.XPATH, using = "//div[@id='component_1']/div/div[3]/div/div[2]")
	public WebElement cruiseShip;

	@FindBy(how = How.XPATH, using = "//div[@class='CfqcQ1jD option']")
	public List<WebElement> cruiseShipElements;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	public WebElement searchCruises;

	@FindBy(how = How.XPATH, using = "//*[@id='ship_overview']//div[1]/div[1]/div[2]/div[1]")
	public WebElement passengersAndCrew;

	@FindBy(how = How.XPATH, using = "//div[@class='_30ZCn9lR']/div[4]")
	public WebElement launchedYear;

	@FindBy(how = How.XPATH, using = "//label[@class='bUKZfPPw']")
	public List<WebElement> languageElements;

	public CruisesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void cruiseLineDropDown() {
		cruiseLine.click();
	}

	public void cruiseLineDropDownElements(String cruiseLineValue) {

		wait.until(ExpectedConditions.visibilityOfAllElements(cruiseLineElements));

		for (WebElement cruiseElements : cruiseLineElements) {
			if (cruiseLineValue.equals(cruiseElements.getText())) {
				cruiseElements.click();
				break;
			}
		}
	}

	public void cruiseShipDropDown() {
		cruiseShip.click();
	}

	public void cruiseShipDropDownElements(String cruiseShipValue) {

		wait.until(ExpectedConditions.visibilityOfAllElements(cruiseShipElements));

		for (WebElement cruiseShipElement : cruiseShipElements) {
			if (cruiseShipValue.equals(cruiseShipElement.getText())) {
				cruiseShipElement.click();
				break;
			}
		}
	}

	public void searchCruises() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchCruises.click();
	}

	public void getpassengerAndCrew() {
		String passengerNcrew = passengersAndCrew.getText();

		passenger = passenger + passengerNcrew.substring(12, 15);
//	    System.out.println(passenger);

		crew = crew + passengerNcrew.substring(28, passengerNcrew.length());
//	    System.out.println(crew);
	}

	public String setLaunchedYear() {
		String launchYearText = launchedYear.getText();

		launchedYearText = launchedYearText
				+ launchYearText.substring((launchYearText.length() - 7), (launchYearText.length()));
		return launchedYearText;
	}

	public String[] getLanguages() {
		int size = languageElements.size();
		String s;
		String[] languages = new String[size];
		for (int i = 0; i < size; i++) {
				s=languageElements.get(i).getText();
	            languages[i]=s.substring(0, (s.length()-3));
		}
		return languages;
	}

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

				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
	}
}
