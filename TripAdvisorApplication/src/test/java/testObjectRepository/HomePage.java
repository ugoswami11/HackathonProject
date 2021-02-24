package testObjectRepository;
/*
This class locates all the elements present in TripAdvisor.in Home page and performs required action on them
*/

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	final WebDriver driver;
	public static WebDriverWait wait;
	
	//locate "Holiday Homes" button
	@FindBy(how =How.XPATH, using = "//span[contains(text(),'Holiday Homes')]")			
	public WebElement holidayHomesBtn;
	
	//locate "Where To" search box
	@FindBy(how =How.XPATH, using = "//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m _3awdcWrG']//input[@placeholder='Where to?']")
	public WebElement whereTo;									
	
	//locate "Where To" dropdown
	@FindBy(how = How.XPATH, using = "//div[@class='_27pk-lCQ']/a")
	public List<WebElement> whereToDropDown; 							
	
	//waits untill the page get loaded
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);							
	}
	//clicking on "Holiday Homes" button
	public void holidayHomeButton() {
		holidayHomesBtn.click();								
	}
	
	//waits until "Where To" search box is visible
	//sending value to the "Where To" search box
	public void setWhereTo(String destinationName) {
		wait.until(ExpectedConditions.visibilityOf(whereTo));					
		
		whereTo.sendKeys(destinationName);							
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//clicking on the option present in the "Where To" dropdown
	public void selectDestination() {
		wait.until(ExpectedConditions.visibilityOfAllElements(whereToDropDown));
		whereToDropDown.get(0).click();								

	}
	
}
