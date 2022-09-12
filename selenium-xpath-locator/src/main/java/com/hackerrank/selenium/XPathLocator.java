package com.hackerrank.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathLocator {

    public static String relativeXPathForInput(WebDriver driver, String pageUrl) {
        //return xpath
        driver.get(pageUrl);
        //below div will return 5 elements, both "label" and "input" work
        String xpath = "//div[@id='bucket']/label";
        //String xpath = "//div[@id='bucket']/input";
        return xpath;
    }

    public static String absoluteXPathForInput(WebDriver driver, String pageUrl) {
        //return xpath
        String xpath = "/html/body/div/section/div[@id='bucket']/input";
        return xpath;
    }
}
