
package com.finals.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.finals.framework.utils.ConfigReader;

import java.net.URL;

public class DriverFactory {
    public static WebDriver createInstance(String browser, String hubURL) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            caps.merge(options);
            caps.setBrowserName("chrome");
        } else {
            FirefoxOptions options = new FirefoxOptions();
            caps.merge(options);
            caps.setBrowserName("firefox");
        }
        return new RemoteWebDriver(new URL(hubURL), caps);
    }
}
