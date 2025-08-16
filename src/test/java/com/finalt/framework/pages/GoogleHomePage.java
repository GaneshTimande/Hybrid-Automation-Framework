
package com.finalt.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;
    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) { this.driver = driver; }
    public void open() { driver.get("https://www.google.com"); }
    public WebElement searchBoxElement() { return driver.findElement(searchBox); }
    public void search(String text) {
        searchBoxElement().sendKeys(text);
        searchBoxElement().submit();
    }
}
