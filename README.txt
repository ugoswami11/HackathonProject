PROBLEM STATEMENT : Calculate Trip Cost

  -Display total amount and charges per night for 3 holiday homes: 1. For 4 people in Nairobi from 15th Dec-2019 to 20th Dec-2019 
  -Sort the list with highest traveler rating on top. 3. Holiday home should have elevator/ List access. 
  (Suggested Site: tripadvisor.in however you are free to choose any other legitimate site)+B6

DETAILED DESCRIPTION:HACKATHON IDEAS

1. Display Hotel name, total amount and charges per night for 3 holiday homes for 4 people in Nairobi for 5 days of stay from tomorrow's date;
   Should have sorted the list with highest traveler rating & should have elevator/ List access  
2. Pick one cruise line & pick a respective cruise ship under Cruises;
         a. Retrieve all the languages offered and store in a List; Display the same 
         b. Display passengers, crew & launched year (Suggested Site: tripadvisor.in however you are free to choose any other legitimate site)

REFERENCE FOLDERS
1) Extent reports can be accessed from reports folder.
2) Screenshots taken during test execution are stored in screenshots folder.
3) Input and Output datatables are stored in Datatables folder.
      
-------------------------------------------------------------------------------------------------------------------------------------------------------

PRE-REQUISITES:

(1)- Java version :jdk1.8.0_271
(2)- Selenium version :3.141.59 jar
(3)- TestNG version :7.1.0
(4)- Apache Maven version : 3.6.3
(5)- Apache POI version : 4.1.2
(6)- Commons IO version :2.8.0
(7)- Chrome browser version : 86.0.4240.111
(8)- Firefox version : 83.0

----------------------------------------------------------------------------------------------------------------------------------------------------

STEPS TO EXECUTE THE FUNCTIONAL TEST CASES:

HolidayHomeFunctionality

(1) Navigate to https://tripadvisor.in
(2) Enter a valid value for "Where to?" textbox field
(3) Select a valid place name from the new window
(4) Select [Holiday Homes] button
(5) Select a valid date for "Check-in" listbox field
(6) Select a valid date for "Check-out" listbox field
(7) Select a valid value for "Guests" listbox field
(8) Select 'Traveller Rating' under "Sort by" listbox field
(9) Select "Elevator/lift access " check box under "Amenities"

CruisesFunctionality

(1) Navigate to https://www.tripadvisor.in/Cruises
(2) Select a valid value for "Cruise Line" List box field 
(3) Select a valid value for "Cruise Ship" List box  field
(4) Click on the [Search] button

-------------------------------------------------------------------------------------------------------------------------------------------

OUTPUT IN CHROME AND FIREFOX


Elegant Cosy Conquest
8,294
41,473 / 5 nights
City/River View Retreat in the Heart of Westlands
5,972
29,860 / 5 nights
City/River View Retreat in the Heart of Westlands
5,972
29,860 / 5 nights
Passengers: 242    Crew: 50 Launched: 2002   
English














