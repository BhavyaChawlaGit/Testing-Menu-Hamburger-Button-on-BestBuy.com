
* (C) Copyright 2021 Boni Garcia (https://bonigarcia.github.io/)
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* Updated by Bhavya Chawla (bchawla@hawk.iit.edu)
*/
package io.github.bonigarcia.webdriver.jupiter.ch03.locators;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

class BestBuyHomepageTest {

   WebDriver driver;

   @BeforeEach
   void setup() {
       driver = WebDriverManager.chromedriver().create();

       // Loading BestBuy Homepage takes roughly 3 seconds to complete loading the page/elements
       // We will get 'ElementNotVisibleException' if there is a delay in loading particular element
       // which Webdriver wants to interact.
       // So, the best solution is do implicit wait for few seconds.

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

   @AfterEach
   void teardown() throws InterruptedException {
       // FIXME: pause for manual browser inspection
       driver.quit();
       Thread.sleep(Duration.ofSeconds(5).toMillis());

   }


   @Test
   void testBestBuyHomepageHeaderElements() {
       String sutUrl = "https://www.bestbuy.com/";
       driver.get(sutUrl);

       assertThat(driver.getTitle())
               .isEqualTo("Best Buy | Official Online Store | Shop Now & Save");
       assertThat(driver.getCurrentUrl()).isEqualTo(sutUrl);
       assertThat(driver.getPageSource()).containsIgnoringCase("</html>");

       // By name
       // Verify Auto-Complete Search field is enabled

       WebElement textByName = driver.findElement(By.name("frmSearch"));
       assertThat(textByName.isEnabled()).isTrue();

       // By XPath
       // Verify Menu button is displayed
       WebElement menu_button = driver.findElement(By.xpath("//button[@aria-label='Menu']"));
       assertThat(menu_button.isDisplayed()).isTrue();

       // By XPath
       // Verify Store button is displayed
       WebElement store_location_button = driver.findElement(By.xpath("//*[@id=\"lt-container\"]/div/div/span/span/button"));
       assertThat(store_location_button.isDisplayed()).isTrue();


       // By linkText
       // Verify Shopping Cart title
       WebElement linkByText = driver.findElement(By.linkText("Cart"));
       assertThat(linkByText.getTagName()).isEqualTo("a");
       assertThat(linkByText.getAttribute("title")).isEqualTo("Cart");

       // By XPath
       // Verify Account menu button is displayed
       WebElement account_menu_button = driver.findElement(By.xpath("//*[@id=\"account-menu-account-button\"]/span"));
       assertThat(account_menu_button.isDisplayed()).isTrue();
       account_menu_button.click();

       // By XPath
       // Verify Sign In button is displayed using anchor with href

       WebElement sign_in_button = driver.findElement(By.xpath("//a[contains(@href,'/identity/global/signin')]"));
       String href = sign_in_button.getAttribute("href");
       assertThat(account_menu_button.isDisplayed()).isTrue();
       System.out.println("innerText : " + sign_in_button.getAttribute("innerText"));
       System.out.println("outerText : " + sign_in_button.getAttribute("outerText"));

       String tagName = sign_in_button.getTagName();
       System.out.println("TagName : " + tagName);

       String innerHTML = sign_in_button.getAttribute("innerHTML");
       System.out.println("innerHTML : " + innerHTML);

       String text = sign_in_button.getText();
       System.out.println("Sign In text : " + text);

       // By XPath
       // Verify Sign In button is displayed using class and text
       WebElement sign_in_button_1 = driver.findElement(By.xpath("//*[@class='c-button c-button-secondary c-button-sm sign-in-btn' and contains(text(),'Sign In')]"));
       System.out.println("sign_in_button_1 TagName: " + sign_in_button_1.getTagName());
       System.out.println("sign_in_button_1 Text: " + sign_in_button_1.getText());
       assertThat(sign_in_button_1.getText()).isEqualTo("Sign In");

       // Slow Selenium down ... for assert to catchup ...
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }

       // By XPath
       // Verify Create Account button is displayed using class and text
       WebElement create_account_button = driver.findElement(By.xpath("//*[@class='c-button c-button-outline c-button-sm create-account-btn' and contains(text(),'Create Account')]"));
       System.out.println("create_account_button TagName: " + create_account_button.getTagName());
       System.out.println("create_account_button Text: " + create_account_button.getText());
       assertThat(create_account_button.getText()).isEqualTo("Create Account");


       // By XPath
       // Verify Check Order Status using anchor with href
       WebElement check_order_status = driver.findElement(By.xpath("//a[contains(@href,'/profile/ss/orderlookup')]"));
       assertThat(check_order_status.isDisplayed()).isTrue();
       System.out.println("Check Order Status text : " + check_order_status.getText());

       try {
           Thread.sleep(5000);
           System.out.println("\n\n\n  Test ... Completed  - Remove this when you are done unit-testing your code \n\n\n");
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }

   }

   @Test
   void testBestBuyEmailSignUp() {
       driver.get(
               "https://www.bestbuy.com/");

       WebElement inputText = driver.findElement(By.name("footer-email-signup"));
       String textValue = "mySeleliumTest@gmail.com";
       inputText.sendKeys(textValue);
       assertThat(inputText.getAttribute("value")).isEqualTo(textValue);


       //inputText.clear();

       //assertThat(inputText.getAttribute("value")).isEmpty();
   }
   
   @Test
   void testFirstLevelMenu() throws InterruptedException {

       //opening webpage on driver
       driver.get("https://www.bestbuy.com/?intl=nosplash");
       driver.manage().window().maximize();

       //Click on the Menu button and ensure that the menu expands.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> elements = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       if (!elements.isEmpty()) {
           WebElement firstElement = elements.get(0);
           String elementText = firstElement.getText();
           assertThat(elementText).isEqualTo("Deals");

       }

       //Click on the Menu button again and verify that the menu close.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();

       //Click on menu item and confirm redirection
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> menulist = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist.get(0).click();



       //first menu item
       List<WebElement> menulist01 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist01.get(2).click();
       String menu1text = driver.findElement(By.xpath("//*[@class=\"hamburger-menu-title\"]")).getText();
       assertThat(menu1text).isEqualTo("Appliances");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();

       //Second menu item 
       List<WebElement> menulist02 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist02.get(4).click();
       String menu2text = driver.findElement(By.xpath("//*[@class=\"hamburger-menu-title\"]")).getText();
       assertThat(menu2text).isEqualTo("TV & Home Theater");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();


       //Third menu item
       List<WebElement> menulist03 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist03.get(5).click();
       String menu3text = driver.findElement(By.xpath("//*[@class=\"hamburger-menu-title\"]")).getText();
       assertThat(menu3text).isEqualTo("Computers & Tablets");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();

   }

   @Test
   void testSecondLevelMenu() throws InterruptedException {

       //opening webpage on driver
       driver.get("https://www.bestbuy.com/?intl=nosplash");
       driver.manage().window().maximize();

       //Click on the Menu button and ensure that the menu expands.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> elements = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       if (!elements.isEmpty()) {
           WebElement firstElement = elements.get(0);
           String elementText = firstElement.getText();
           assertThat(elementText).isEqualTo("Deals");

       }

       //Click on the Menu button again and verify that the menu close.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();

       //Click on menu item and confirm redirection
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> menulist = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist.get(0).click();

       //Click on the first menu item in the second level menu and verify proper redirection,
       List<WebElement> menulist_01 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist_01.get(3).click();
       Thread.sleep(3000);
       List<WebElement> submenulist_01 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       submenulist_01.get(0).click();
       String submenu1 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu1).isEqualTo("Major Kitchen Appliances");
       submenulist_01.get(1).click();
       String submenu1_2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu1_2).isEqualTo("Small Kitchen Appliances");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();

       //Click on the Second menu item in the second level menu and verify proper redirection
       List<WebElement> menulist_02 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist_02.get(4).click();
       Thread.sleep(3000);
       List<WebElement> submenulist_02 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       submenulist_02.get(0).click();
       String submenu2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu2).isEqualTo("TVs by Size");
       submenulist_02.get(1).click();
       String submenu2_1 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu2_1).isEqualTo("TVs by Type");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();

       //Click on the Third menu item in the second level menu and verify proper redirection
       List<WebElement> menulist_03 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist_03.get(5).click();
       Thread.sleep(3000);
       List<WebElement> submenulist_03 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       submenulist_03.get(0).click();
       String submenu3 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu3).isEqualTo("Laptops & Desktops");
       submenulist_03.get(1).click();
       String submenu3_1 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(submenu3_1).isEqualTo("Tablets");
       driver.findElement(By.xpath("//*[@class=\"hamburger-menu-back-button-title\"]/button")).click();

   }

   @Test
   void testThirdLevelMenu() throws InterruptedException {

       //opening webpage on driver
       driver.get("https://www.bestbuy.com/?intl=nosplash");
       driver.manage().window().maximize();

       //Click on the Menu button and ensure that the menu expands.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> elements = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       if (!elements.isEmpty()) {
           WebElement firstElement = elements.get(0);
           String elementText = firstElement.getText();
           assertThat(elementText).isEqualTo("Deals");

       }

       //Click on the Menu button again and verify that the menu close.
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();

       //Click on menu item and confirm redirection
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
       List<WebElement> menulist = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       menulist.get(0).click();

       //first menu item Third level menu 
       List<WebElement> Third_menulist_01 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_menulist_01.get(3).click();
       Thread.sleep(3000);
       List<WebElement> Third_submenulist_01 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_submenulist_01.get(0).click();
       String Third_submenu1 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu1).isEqualTo("Major Kitchen Appliances");
       Third_submenulist_01.get(1).click();
       String Third_submenu1_2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu1_2).isEqualTo("Small Kitchen Appliances");
       List<WebElement> Third_sub_menu_01 = driver.findElements(By.xpath("//*[@class=\"liDropdownList\"]"));
       Third_sub_menu_01.get(1).click();
       Thread.sleep(3000);
       String pagename=driver.findElement(By.xpath("//*[@class=\"browse-title title\"]")).getText();
       assertThat(pagename).isEqualTo("Air Fryers & Deep Fryers");
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();

       //Second menu item - Third level menu 
       List<WebElement> Third_menulist_02 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_menulist_02.get(4).click();
       Thread.sleep(3000);
       List<WebElement> Third_submenulist_02 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_submenulist_02.get(0).click();
       String Third_submenu2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu2).isEqualTo("TVs by Size");
       Third_submenulist_02.get(1).click();
       String Third_submenu2_2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu2_2).isEqualTo("TVs by Type");
       List<WebElement> Third_sub_menu_02 = driver.findElements(By.xpath("//*[@class=\"liDropdownList\"]"));
       Third_sub_menu_02.get(1).click();
       Thread.sleep(3000);
       String pagename2=driver.findElement(By.xpath("//*[@class=\"browse-title title\"]")).getText();
       assertThat(pagename2).isEqualTo("TVs Under $500");
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();



       //Third menu item  Third level menu 
       List<WebElement> Third_menulist_03 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_menulist_03.get(5).click();
       Thread.sleep(3000);
       List<WebElement> Third_submenulist_03 = driver.findElements(By.xpath("//*[@class='liDropdownList ']"));
       Third_submenulist_03.get(0).click();
       String Third_submenu3 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu3).isEqualTo("Laptops & Desktops");
       Third_submenulist_03.get(1).click();
       String Third_submenu3_2 = driver.findElement(By.xpath("//*[@class=\"sideCarHeader\"]")).getText();
       assertThat(Third_submenu3_2).isEqualTo("Tablets");
       List<WebElement> Third_sub_menu_03 = driver.findElements(By.xpath("//*[@class=\"liDropdownList\"]"));
       Third_sub_menu_03.get(1).click();
       Thread.sleep(3000);
       String pagename3=driver.findElement(By.xpath("//*[@class=\"browse-title title\"]")).getText();
       assertThat(pagename3).isEqualTo("Microsoft Surface Tablets");
       driver.findElement(By.xpath("//*[@class=\"top-nav\"]/nav/button")).click();
   
   
   
   
   }



}
