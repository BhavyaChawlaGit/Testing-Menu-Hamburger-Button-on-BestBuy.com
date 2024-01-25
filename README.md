# Testing-Menu-Hamburger-Button-on-BestBuy.com using selenium-webdriver-java (Copyright © 2021-2024)

**BestBuyHomepageTest.java** _(src/test/java/io/github/bonigarcia/webdriver/jupiter/ch03/locators)_ along with the Selenium tool to inspect and test the design of the Menu-Hamburger-Button, for BestBuy Homepage (https://www.bestbuy.com/)  

Total Test cases would be 20 (menu items) * 3 (Level 2 elements) * 2 (Level 3 elements) = 120 test cases  

## Test Plan:
### 1. Level 1 Menu Items: 20 Test Cases  
● Test each Level 1 menu item's visibility and accessibility  
● Verify that clicking on each item opens the corresponding Level 2 sub-menu  
### 2. Level 2 Sub-Menus: 60 Test Cases  
● For each Level 1 menu item, navigate to the corresponding Level 2 sub-menu  
● Test each Level 2 sub-menus visibility and accessibility  
● Verify that clicking on each item within the Level 2 sub-menu opens the corresponding Level 3 sub-menu or page  
### 3. Level 3 Sub-Menus: 120 Test Cases  
● For each Level 1 menu item:  
● Navigate to the corresponding Level 2 sub-menu  
● Navigate to the corresponding Level 3 sub-menu  
● Test each Level 3 sub-menus visibility and accessibility  
● Verify that clicking on each item within the Level 3 sub-menu performs the expected action  

I have made sure to validate that the Menu-Hamburger-Button is displayed on the BestBuyhomepage and initially, I check that the menu opens and closes when clicked again at the start of every level test.  
The tests are performed on Chrome browser only and can be operated on any operating system, for example, MacOS, Windows, or Linux  
The menu items are accessed by Xpath, and only clicking action is performed for all the tests.  

## S-Curve chart to track Test Progress (use the test points calculated for every test case listed the prior requirement) with bars to represent Planned, Attempted, and Actual test cases

![image](https://github.com/BhavyaChawlaGit/Testing-Menu-Hamburger-Button-on-BestBuy.com/assets/112718303/ab642493-6b5e-4e97-b04a-e199b9d8cb57)


Consisting of various WebElements/Sector like 3 dropdown lists/menus, and featured sections, followed by flyout list items below, the structural components within the Hamburger-Button menu are as follows:  
The web components of the menu is under Menu-Container, which takes to the level 2 menu/submenu which is Flyout-SideCar-List, and thereafter to the level 3 menu.  

![image](https://github.com/BhavyaChawlaGit/Testing-Menu-Hamburger-Button-on-BestBuy.com/assets/112718303/54ad6d2c-bbfc-4f22-869b-47451abc2430)


![image](https://github.com/BhavyaChawlaGit/Testing-Menu-Hamburger-Button-on-BestBuy.com/assets/112718303/d435757a-1000-4106-8a7c-cfab29abd212)

## Hands-On Selenium WebDriver with Java
selenium-webdriver-java (Copyright © 2021-2024) is an open-source project created and maintained by Boni Garcia, licensed under the terms of Apache 2.0 License  

https://github.com/bonigarcia/selenium-webdriver-java?tab=readme-ov-file