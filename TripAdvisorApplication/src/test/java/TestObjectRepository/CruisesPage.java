package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CruisesPage {
	
	//final WebDriver driver;
	
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
	
	@FindBy(how = How.XPATH, using="//*[@id='ship_overview']//div[1]/div[1]/div[2]/div[1]")
	public WebElement passengersAndCrew;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ship_overview\"]//div[1]/div[1]/div[2]/div[3]")
	public WebElement launchedYear;
	
	@FindBy (how = How.XPATH, using="//label[@class='bUKZfPPw']")
	public WebElement languages;
	
	public void cruiseLineDropDown(){
		cruiseLine.click();
	}
	
	public void cruiseLineDropDownElements(String cruiseLineValue){
	for (WebElement cruiseElements : cruiseLineElements) {
		if(cruiseLineValue.equals(cruiseElements.getText()))
			cruiseElements.click();
		}
	}
	
	public void cruiseShipDropDown()
	{
		cruiseShip.click();
	}
	
	public void cruiseShipDropDownElements(String cruiseShipValue){
		for (WebElement cruiseShipElement : cruiseShipElements) {
			if(cruiseShipValue.equals(cruiseShipElement.getText()))
				cruiseShipElement.click();
			}
	}
	
	public void searchCruises()
	{
		searchCruises.click();
	}
}
