package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HolidayHomesPage {
	
	//final WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='lRYY2wxe']")
	public WebElement checkIn;
	
	@FindBy(how = How.XPATH , using ="//div[@class='_1rZK5NGr']")
	public WebElement checkOut;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Guests']")
	public WebElement guestSelection;
	
	@FindBy(how = How.XPATH, using = "//div[@class='zGG8H0c4']//div//div[2]//div[1]//div[2]//span[2]")
	public WebElement addGuest;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Apply']")
	public WebElement applyGuest;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1wuPwxoN']")/*******###***/
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
}
