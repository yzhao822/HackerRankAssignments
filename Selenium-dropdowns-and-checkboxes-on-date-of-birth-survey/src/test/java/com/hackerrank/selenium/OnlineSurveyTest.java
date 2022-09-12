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
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class OnlineSurveyTest {
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
    public void testFillDateOfBirth() {
        OnlineSurvey.fillDateOfBirth(driver, pagUrl);
        List<WebElement> selects = driver.findElements(By.tagName("select"));
        assertEquals(3, selects.size());

        for (WebElement select : selects) {
            assertNotEquals("", new Select(select).getFirstSelectedOption().getText());
        }
    }

    @Test
    public void testAnswerQuestions() {
        OnlineSurvey.answerQuestions(driver, pagUrl);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        Set<String> checked = new HashSet<>();
        for (WebElement select : checkBoxes) {
            if (select.isSelected()) {
                if (checked.contains(select.getAttribute("name"))) {
                    fail("multiple options checked");
                }
                checked.add(select.getAttribute("name"));
            }
        }
        assertEquals(3, checked.size());
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}