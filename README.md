# Testing-Menu-Hamburger-Button-on-BestBuy.com
BestBuyHomepageTest.java along with Selenium tool to inspect and test the design of the Menu-Hamburger-Button, for BestBuy Homepage (https://www.bestbuy.com/).  

Total Test cases would be 20 (menu items) * 3 (Level 2 elements) * 2 (Level 3 elements) = 120 test cases  

## Test Plan:
1. Level 1 Menu Items: 20 Test Cases  
● Test each Level 1 menu item's visibility and accessibility  
● Verify that clicking on each item opens the corresponding Level 2 sub-menu  
2. Level 2 Sub-Menus: 60 Test Cases  
● For each Level 1 menu item, navigate to the corresponding Level 2 sub-menu  
● Test each Level 2 sub-menus visibility and accessibility  
● Verify that clicking on each item within the Level 2 sub-menu opens the corresponding Level 3 sub-menu or page  
3. Level 3 Sub-Menus: 120 Test Cases  
● For each Level 1 menu item:  
● Navigate to the corresponding Level 2 sub-menu  
● Navigate to the corresponding Level 3 sub-menu  
● Test each Level 3 sub-menus visibility and accessibility  
● Verify that clicking on each item within the Level 3 sub-menu performs the expected action  

I have made sure to validate that the Menu-Hamburger-Button is displayed on the BestBuyhomepage and initially, I check that the menu opens and closes when clicked again at the start of every level test.  
The tests are performed on Chrome browser only and can be operated on any operating system, for example, MacOS, Windows, or Linux  
The menu items are accessed by Xpath, and only clicking action is performed for all the tests.  

## S-Curve chart to track Test Progress (use the test points calculated for every test case listed the prior requirement) with bars to represent Planned, Attempted, and Actual test cases

image.png




