package com.techproed;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    //Create a class name DropDown
//Go to https://the-internet.herokuapp.com/dropdown

    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void dropdownTest(){
        //Dropdowns are in Select class
        //1. Locate the select element using any locator
        //We are using By.id locator
        WebElement selectElement=driver.findElement(By.id("dropdown")); //located the dropdown element by available element
        //2. Create Select object and pass the selectElement to that object
        Select options=new Select(selectElement);
        //Now we can use the Select object to reach the dropdown option
        //To get the first selected option we use getFirstSelectedOption()
        String firstSelectedOption=options.getFirstSelectedOption().getText();
        System.out.println("First selected "+firstSelectedOption);
            //there are 3 ways to identify dropdown element
            //1.find by index,  2.find by value, 3.find by visible text
        //1.Select and Print Option 1 using index
        //=====SELECT BY INDEX====
        options.selectByIndex(1);
       // options.selectByIndex(2);  //this will select the second index which is Option 2

        //====SELECT BY VALUE=====
        //2.Select and Print Option 2 by value
        options.selectByValue("2"); //selectByValue tahes a String.this will select the option with value=2.

        //====SELECT BY VISIBLE TEXT=====
        //3.Select and Print Option 1 by visible text
        options.selectByVisibleText("Option 1");
        //INTERVIEW Q: If you know the  name of the dropdown option how do you select that element? Lets say the name of option is Flower,
        // then tell me how you can select that element?
        //ANSWER: We can use selectByVisibleText();

        //4.Print all dropdown values
        List<WebElement> allOptions= options.getOptions();
        // this getOptions() returned all of the options. it returns List<WebElement>. to get text, we need getText(); method
        for(WebElement option:allOptions){
            System.out.println(option.getText());
        }

        //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
        System.out.println( options.getOptions().size() == 4  ? true : false  );

        //OR
        int size = allOptions.size();
        if(size == 4) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        //OR
        Assert.assertTrue(allOptions.size()==4);

    }
    @After
    public void tearDown(){
        driver.close();
    }



}
