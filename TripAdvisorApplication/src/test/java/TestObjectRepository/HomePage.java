package testObjectRepository;


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
	
	@FindBy(how =How.XPATH, using = "//span[contains(text(),'Holiday Homes')]")
	public WebElement holidayHomesBtn;
	
	@FindBy(how =How.XPATH, using = "//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m _3awdcWrG']//input[@placeholder='Where to?']")
	public WebElement whereTo;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_27pk-lCQ']/a")
	public List<WebElement> whereToDropDown; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public void holidayHomeButton() {
		holidayHomesBtn.click();
	}
	
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
	
	public void selectDestination() {
		wait.until(ExpectedConditions.visibilityOfAllElements(whereToDropDown));
		whereToDropDown.get(0).click();

	}
	
}
