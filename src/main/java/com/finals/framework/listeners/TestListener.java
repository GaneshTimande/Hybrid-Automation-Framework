
package com.finals.framework.listeners;

import com.finals.framework.base.BaseTest;
import com.finals.framework.reports.ExtentManager;
import com.finals.framework.utils.EmailSender;
import com.finals.framework.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {
        // suite start
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush();
        // send zipped reports folder
        EmailSender.send("Automation Report", "Please find attached report", "reports");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest t = extent.createTest(result.getMethod().getMethodName());
        test.set(t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Passed"); 
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object inst = result.getInstance();
        if (inst instanceof BaseTest) {
            try {
                String path = ScreenshotUtils.take(((BaseTest)inst).getDriver(), result.getMethod().getMethodName());
                test.get().fail(result.getThrowable());
                if (path != null) test.get().addScreenCaptureFromPath(path);
            } catch (Exception e) { e.printStackTrace(); }
        } else {
            test.get().fail(result.getThrowable());
        }
    }

    @Override public void onTestSkipped(ITestResult result) { test.get().skip("Skipped"); }
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
}
