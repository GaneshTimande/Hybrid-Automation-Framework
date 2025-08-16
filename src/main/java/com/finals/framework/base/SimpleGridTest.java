package com.finals.framework.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SimpleGridTest {
	 public static void main(String[] args) {
	        try {
	            // 1. Grid hub URL
	            URL gridUrl = new URL("http://localhost:4444/wd/hub");

	            // 2. Set Firefox options
	            FirefoxOptions options = new FirefoxOptions();
	            options.setPlatformName("LINUX"); // matches Docker node platform
	            options.addArguments("--headless"); // optional: run without GUI
	            options.addArguments("--window-size=1920,1080");

	            // 3. Create RemoteWebDriver
	            RemoteWebDriver driver = new RemoteWebDriver(gridUrl, options);

	            // 4. Navigate to a page
	            driver.get("https://www.google.com");

	            // 5. Print page title
	            System.out.println("Page title is: " + driver.getTitle());

	            // 6. Quit driver
	            driver.quit();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}