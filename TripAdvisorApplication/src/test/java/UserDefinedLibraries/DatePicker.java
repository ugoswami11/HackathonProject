package UserDefinedLibraries;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker {
	
	
	public static void getDateValue(String dateOfJourney, WebDriver driver) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		
		 try {
	    	 //Convert the dateOfJourney String type to Date type
			 Date  dateTypeOfdateOfJouney = (Date) dateFormat.parse(dateOfJourney);
			
			 //Store just the day value from the date in dd format
			 String day = new SimpleDateFormat("dd").format(dateTypeOfdateOfJouney);
			 
			 //Store just the month value of the date in MMMM format
			 String month = new SimpleDateFormat("MMMM").format(dateTypeOfdateOfJouney);
			 
			 //Store just the year value of the date in yyyy format
			 String year = new SimpleDateFormat("yyyy").format(dateTypeOfdateOfJouney);
			 
			 //Parse String value of day to Integer to pick the date from the calendar
			 int dayInt = Integer.parseInt(day);
			 
			 //Concatenate the value of month and year to compare to the String on the calendar field to locate the right month and year to select date
			 String expMonthYear = month+" "+year;
	
			 
			 while(true) {
				 //The month and year displayed on the calendar
				 String displayDate = driver.findElement(By.xpath("//div[@class='_2DSA78he']/div[1]/div[1]")).getText();
				// String displayDate2 = driver.findElement(By.xpath("//*[@id=\"CategoryDetail\"]//table/tbody[2]/tr[1]//tr[1]/th[2]")).getText();
				 
				 //Comparing the expMonthYear to displayDate to navigate to the correct month
				 if(expMonthYear.equals(displayDate)) {
					
					 //if the expMonthYear is equal to the displayDate then the date is selected from the calendar 
					 //the dates are located by xpath
					 //the day which is stored in dayInt is selected and breaks the loop
					 driver.findElement(By.xpath("//div[@class='_2DSA78he']/div[1]/div[3]/div/div[text()='"+dayInt+"']")).click();
					 break;
				 }
				 
				 else if(dateTypeOfdateOfJouney.compareTo(currentDate)>0) {
					 
					 //if the expMonthYear and displayDate is not equal
					 //It compares date to be selected to the current date, if it return greter than 0 that means the date is present in the future
					 //And clicks the right arrow on the calendar to change the month
					 driver.findElement(By.xpath("//div[@class='B_DhIlZY']/div[2]")).click();
				 }
				 else if(dateTypeOfdateOfJouney.compareTo(currentDate)<0) {
					 driver.findElement(By.xpath("//div[@class='B_DhIlZY']/div[1]")).click();
				 }
				 
				 
			 }

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
