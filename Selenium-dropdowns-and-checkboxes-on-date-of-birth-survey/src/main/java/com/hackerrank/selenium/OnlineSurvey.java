package com.hackerrank.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class OnlineSurvey {

    public static void fillDateOfBirth(WebDriver driver, String pageUrl) {
        // complete implementation

        //Create a new instance of the HTML unit driver
        //WebDriver driver = new HtmlUnitDriver();
        
        //navigate to the page
        driver.get(pageUrl);

        //locate the dropdown list using its id
        Select dropdownMonth = new Select(driver.findElement(By.id("month")));
        Select dropdownDay = new Select(driver.findElement(By.id("day")));
        Select dropdownYear = new Select(driver.findElement(By.id("year")));

        //select a value from dropdown list
        dropdownMonth.selectByIndex(1);
        dropdownDay.selectByValue("1");
        dropdownYear.selectByVisibleText("2020");
        
    }

    public static void answerQuestions(WebDriver driver, String pageUrl) {
        // complete implementation

        driver.get(pageUrl);

        //driver.findElement(By.cssSelector("input[value='Java']")).click();

        List<WebElement> allCheckBoxes = driver.findElements(By.className("my-20")); 
        for(WebElement checkbox:allCheckBoxes) {
          checkbox.findElements(By.tagName("input")).get(0).click();
        }
        

    }
}

