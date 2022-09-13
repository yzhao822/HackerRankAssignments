package com.hackerrank.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementLocator {

    public static List<WebElement> locateNonTextTypeElements(WebDriver driver, String pageUrl) {
        //complete implementation
        driver.get(pageUrl);

        //get the form element
        WebElement form = driver.findElement(By.tagName("form"));

        //create a new WebElement List, and assign all input tags
        List<WebElement> allInputElements = form.findElements(By.cssSelector("input"));
        //create an empty list to hold nonTextElements
        List<WebElement> nonTextElements = new ArrayList<>();

        //iterate through the list, check if the element is non text, then add it into nonTextElements
        allInputElements.forEach(webElement -> {
            if (!webElement.getAttribute("type").equals("text")) {
                nonTextElements.add(webElement);
            }
        });
        return nonTextElements;
    }

    public static List<WebElement> locateContactElements(WebDriver driver, String pageUrl) {
        //complete implementation
        driver.get(pageUrl);

        WebElement form = driver.findElement(By.tagName("form"));

        //create a WebElement List starting with "contact"
        List<WebElement> contactElements = form.findElements(By.cssSelector("input[name^='contact']"));

        return contactElements;
    }

    public static WebElement findSubmitElement(WebDriver driver, String pageUrl) {
        //complete implementation
        driver.get(pageUrl);
        WebElement submitElement = driver.findElement(By.cssSelector("button"));
        return submitElement;
    }

    public static List<WebElement> locateIdMissingElements(WebDriver driver, String pageUrl) {
        //complete implementation
        driver.get(pageUrl);
        WebElement form = driver.findElement(By.tagName("form"));

        List<WebElement> allInputElements = form.findElements(By.cssSelector("input"));
        List<WebElement> missingElements = new ArrayList<>();

        allInputElements.forEach(webElement -> {
            if (webElement.getAttribute("id")==null) {
                missingElements.add(webElement);
            }
        });

        return missingElements;
    }
}
