package com.finals.framework.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTest {
    protected RemoteWebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // optional
            options.setPlatformName("LINUX");           // Docker node is Linux
            
            // Optional: headless mode for server without GUI
            // options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");

            System.out.println("Connecting to Selenium Grid at: http://localhost:4444/wd/hub");
            
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
