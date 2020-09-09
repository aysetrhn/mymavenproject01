package com.seleniumofficehours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AppleTests {

    private WebDriver driver;
    // create the setUp() function with before annotation and get apple.com
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/");
    }
    // Verify that the first item listed on the homepage is iPhone 11 Pro by locating its header element
    // Hint: isDisplayed()
    @Test
    public void firstHeaderTest(){
        WebElement header = driver.findElement(By.xpath("(//h2[@class='headline'])[1]"));
        Assert.assertTrue(header.isDisplayed());
    }
    // print all the elements with classname "headline" on the console
    // Hint 1: List
    // Hint 2: foreach
    @Test
    public void printAllHeadersTest(){
        List<WebElement> allHeaders = driver.findElements(By.xpath("//*[@class='headline']"));
        for(WebElement eachHeader : allHeaders){
            System.out.println(eachHeader.getText());
        }
    }
    // verify that "Add to Bag" button is disabled at the following page:
    // https://www.apple.com/shop/product/MXQT2LL/A/magic-keyboard-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english
    // Hint: isEnabled()
    @Test
    public void addToBagTest(){
        driver.navigate().to("https://www.apple.com/shop/product/MXQT2LL/A/magic-keyboard-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
        WebElement addToCardButton = driver.findElement(By.name("add-to-cart"));
        Assert.assertFalse(addToCardButton.isEnabled());
    }

    // search for "ipad keyboard", go to "Accessories" tab, and verify that at least one item is displayed
    // Hint: implicitlyWait()
    // instructor's note: students must first check the price manually
    // go to "https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english"
    // page and select "12.9-inch iPad Pro" option from the size list
    // then click "Add to Bag"
    // verify that the total is $212.93
    @After
    public void tearDown(){
        driver.quit();
    }
}
