
package com.finals.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static WebElement waitForVisible(WebDriver driver, WebElement el, int secs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(el));
    }
}
