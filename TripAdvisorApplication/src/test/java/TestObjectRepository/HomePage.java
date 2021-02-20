package TestObjectRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	final WebDriver driver;
	
	@FindBy(how =How.XPATH, using = "//span[contains(text(),'Holiday Homes')]")
	public WebElement holidayHomesBtn;
	
	@FindBy(how =How.XPATH, using = "//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m _3awdcWrG']//input[@placeholder='Where to?']")
	public WebElement whereTo;
	
	@FindBy(how = How.XPATH, using = "//div[2]//form/div/a")
	public List<WebElement> whereToDropDown; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void holidayHomeButton() {
		holidayHomesBtn.click();
	}
	
	public void setWhereTo(String destinationName) {
		whereTo.sendKeys(destinationName);
	}
	
}
