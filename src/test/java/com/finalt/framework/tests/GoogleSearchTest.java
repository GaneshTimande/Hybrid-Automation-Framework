package com.finalt.framework.tests;

import com.finals.framework.base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {


    @Test
    public void googleSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium Grid" + Keys.ENTER);
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.toLowerCase().contains("selenium grid"));
    }
}
