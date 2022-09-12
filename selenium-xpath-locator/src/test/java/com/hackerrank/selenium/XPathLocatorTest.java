package com.hackerrank.selenium;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XPathLocatorTest {
    static WebDriver driver = null;
    static String pagUrl = null;

    @BeforeClass
    public static void setup() {
        driver = new HtmlUnitDriver(BrowserVersion.CHROME, false) {
            @Override
            protected WebClient newWebClient(BrowserVersion version) {
                WebClient webClient = super.newWebClient(version);
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                return webClient;
            }
        };
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        pagUrl = "file://" + System.getProperty("user.dir") + "/website/home.html";
    }

    @Test
    public void testAbsoluteXPathForInput() {
        String xpath = XPathLocator.absoluteXPathForInput(driver, pagUrl);

        assertTrue(xpath.contains("html"));

        driver.get(pagUrl);
        assertEquals(5, driver.findElements(By.xpath(xpath)).size());
    }

    @Test
    public void testRelativeXPathForInput() {
        String xpath = XPathLocator.relativeXPathForInput(driver, pagUrl);

        assertTrue(!xpath.contains("html"));

        driver.get(pagUrl);
        assertEquals(5, driver.findElements(By.xpath(xpath)).size());
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
