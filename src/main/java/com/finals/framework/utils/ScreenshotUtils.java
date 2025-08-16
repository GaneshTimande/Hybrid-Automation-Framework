
package com.finals.framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static String take(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dest = "reports/screenshots/" + name + "_" + ts + ".png";
            FileUtils.copyFile(src, new File(dest));
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
