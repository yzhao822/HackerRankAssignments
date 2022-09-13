package com.hackerrank.selenium;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ElementLocatorTest {
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
    public void testNonTextTypeElements() {
        List<WebElement> elementList = ElementLocator.locateNonTextTypeElements(driver, pagUrl);

        assertEquals(3, elementList.size());
        assertEquals(3, elementList.stream().filter(e -> "radio".equals(e.getAttribute("type"))).count());
    }

    @Test
    public void testLocateContactElements() {
        List<WebElement> elementList = ElementLocator.locateContactElements(driver, pagUrl);

        assertEquals(3, elementList.size());
        assertEquals(1, elementList.stream().filter(e -> null == e.getAttribute("id")).count());
        assertEquals(2, elementList.stream().filter(e -> null != e.getAttribute("id")).count());

        WebElement element = elementList.stream().filter(e -> null == e.getAttribute("id")).collect(Collectors.toList()).get(0);
        assertEquals("Your email", element.getAttribute("placeholder"));
        assertEquals("form", element.findElement(By.xpath("..")).getTagName());
    }

    @Test
    public void testSubmitButton() {
        WebElement element = ElementLocator.findSubmitElement(driver, pagUrl);
        assertEquals("Send", element.getAttribute("value"));
        assertEquals("form", element.findElement(By.xpath("..")).getTagName());
    }

    @Test
    public void testLocateIdMissingElements() {
        List<WebElement> elementList = ElementLocator.locateIdMissingElements(driver, pagUrl);

        assertEquals(4, elementList.size());
        assertEquals(1, elementList.stream().filter(e -> "text".equals(e.getAttribute("type"))).count());
        assertEquals(3, elementList.stream().filter(e -> "radio".equals(e.getAttribute("type"))).count());
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
