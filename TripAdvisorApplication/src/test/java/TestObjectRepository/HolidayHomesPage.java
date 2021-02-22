package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UserDefinedLibraries.DatePicker;

public class HolidayHomesPage {

	final WebDriver driver;
	public static WebDriverWait wait;

	@FindBy(how = How.XPATH, using = "//div[@class='lRYY2wxe']")
	public WebElement checkIn;

	@FindBy(how = How.XPATH, using = "//div[@class='_1rZK5NGr']")
	public WebElement checkOut;

	@FindBy(how = How.XPATH, using = "//div[@class='_2DSA78he']/div[1]/div[1]")
	public WebElement calendar;

	@FindBy(how = How.XPATH, using = "//div[text()='Guests']")
	public WebElement guestSelection;

	@FindBy(how = How.XPATH, using = "//div[@class='_1h6PBHw9']/input")
	public List<WebElement> guestNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='zGG8H0c4']//div//div[2]//div[1]//div[2]//span[2]")
	public WebElement addGuest;

	@FindBy(how = How.XPATH, using = "//button[text()='Apply']")
	public WebElement applyGuest;

	@FindBy(how = How.XPATH, using = "//div[@class='_1wuPwxoN']") /******* ### ***/
	public WebElement sortBy;

	@FindBy(how = How.XPATH, using = "//div[@class='_16IExTAJ _1S9IhgUs mXy0TSnT _1Jb5DjSv']/div")
	public List<WebElement> sortByItems;

	@FindBy(how = How.XPATH, using = "//span[@class='_3ncH7U-p']")
	public List<WebElement> amenitiesShowMore;

	@FindBy(how = How.XPATH, using = "//div[@id='component_2']//div[10]/div/label")
	public WebElement liftAccess;

	@FindBy(how = How.XPATH, using = "//div[@class='_1L5PA1gU']/div/div/div[2]/a")
	public List<WebElement> hotelNames;

	@FindBy(how = How.XPATH, using = "//div[@class='KhjlbpT7']/div/div[2]")
	public List<WebElement> totalPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='_33TIi_t4']")
	public List<WebElement> pricePerNight;

	@FindBy(how = How.XPATH, using = "//span[text()='Cruises']")
	public WebElement cruisesBtn;

	public HolidayHomesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void checkInDateClick() {
		checkIn.click();
	}

	public void setCheckInDate(String checkInDate) {
		wait.until(ExpectedConditions.visibilityOf(calendar));
		DatePicker.getDateValue(checkInDate, driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkOutDateClick() {
		checkOut.click();
	}

	public void setCheckOutDate(String checkOutDate) {
		wait.until(ExpectedConditions.visibilityOf(calendar));
		DatePicker.getDateValue(checkOutDate, driver);
	}

	public void guestButton() {
		guestSelection.click();
	}

	public void addPerson(String guestNum) {
		wait.until(ExpectedConditions.visibilityOfAllElements(guestNumber));

		while (true) {
			if (guestNumber.get(1).getAttribute("value").contains("4")) {
				break;
			}
			addGuest.click();
		}
	}

	public void applyButton() {
		applyGuest.click();
	}

	public void sortByDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(sortBy));
		sortBy.click();
	}

	public void sortByOptions() {
		wait.until(ExpectedConditions.visibilityOfAllElements(sortByItems));
		sortByItems.get(3).click();
	}

	public void showMoreBox() {

		amenitiesShowMore.get(1).click();
	}

	public void liftAccessCheckbox() {

		liftAccess.click();
	}

	public void cruisesTab() {

		cruisesBtn.click();
	}

}
