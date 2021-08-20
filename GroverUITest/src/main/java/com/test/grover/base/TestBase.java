package com.test.grover.base;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.utility.ConfigReader;

import coreFramework.base.ExtentReport;
import coreFramework.base.LocalBrowserInitialzation;
import coreFramework.helper.ScreenshotHelper;



public class TestBase {
    ConfigReader reader = new ConfigReader();

    String screenshotPath = System.getProperty("user.dir") + "//Screenshots/" + timestamp() + ".png";
    ExtentTest Reportlogger;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initiliazeExtentReport(System.getProperty("user.dir") + "//" + "GroverReport" + "//" + createFolder() + "//" + timestamp() + "Grover.html",
            System.getProperty("user.dir") + reader.extent_XML_path());
    }





    @BeforeMethod(alwaysRun = true)

    public void nameBefore(Method method) {
        String testName = method.getName();
        Reportlogger = ExtentReport.extent.startTest(testName);

    }

    @BeforeTest
    @Parameters("Browser")
    public void initialzeBrowser(String browserName) {
        LocalBrowserInitialzation.setup(reader.app_url(), browserName);


    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) {
        String screenshotPath = null;
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                screenshotPath = System.getProperty("user.dir") + "//Screenshots//" + timestamp() + ".png";
                ScreenshotHelper.captureScreenshot(LocalBrowserInitialzation.driver, screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Reportlogger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            Reportlogger.log(LogStatus.FAIL, "Snapshot below: " +
                Reportlogger.addScreenCapture(screenshotPath));
            Reportlogger.log(LogStatus.FAIL, "Test case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            Reportlogger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
            Reportlogger.log(LogStatus.SKIP, "Test case errors  are " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Reportlogger.log(LogStatus.PASS, "Test case passed is " + result.getName());

        }
        ExtentReport.extent.endTest(Reportlogger);
    }

    @AfterTest
    public void TearDown() {
        LocalBrowserInitialzation.quitDriver();
    }

    @AfterSuite
    public void closeExtentReport() {
        ExtentReport.extent.flush();
        ExtentReport.extent.close();

    }


    public String createFolder() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(now);
        File dir = new File(time);
        dir.mkdir();
        return dir.toString();
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }


    public void reportLog(String message) {
        Reportlogger.log(LogStatus.INFO, message); //For extentTest HTML report


    }
}