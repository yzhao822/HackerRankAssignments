## Environment:
- Java version: 1.8
- Maven version: 3.*
- Selenium HtmlUnitDriver: 2.52.0

## Read-Only Files:
- src/test/*
- website/*

## Requirements:
In this challenge, you are going to use the Selenium WebDriver, the HtmlUnitDriver, which uses the HtmlUnit headless browser. This means you don't need to set up the browser (like Firefox or Chrome) nor a web driver executable (like FirefoxDriver or ChromeDriver). Every web page has web elements (aka DOM objects) with unique names or ids. Names are usually unique, but this is not a restriction.


There is a class `XPathLocator` that has 2 methods:

1. `relativeXPathForInput`: Returns the relative xpath for locating all the *input* elements that are inside *div* having id *bucket*.
2. `absoluteXPathForInput`: Returns the absolute xpath for locating all the *input* elements that are inside *div* having id *bucket*.

These methods have 2 parameters, one web driver and one web page URL. The supplied web page will look like the following:

![web page](webPage.png)

Your task is to complete the implementation of these 2 methods so that the unit tests pass while running the tests.

## Commands
- run: 
```bash
mvn clean package; java -jar target/selenium-java-xpath-locator-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
