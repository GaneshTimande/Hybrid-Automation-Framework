
package com.finals.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            String path = "reports/ExtentReport.html";
            new File("reports").mkdirs();
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Extent Report");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
