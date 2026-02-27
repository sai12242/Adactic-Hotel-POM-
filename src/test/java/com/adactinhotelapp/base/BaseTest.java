package com.adactinhotelapp.base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.adactinhotelapp.factory.DriverFactory;
import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected DriverFactory driverFactory;
    protected Properties prop;

    @BeforeTest
    public void setUp() {
        driverFactory = new DriverFactory();
        prop = driverFactory.initProp();   // ✅ STORE IT
    }

    @BeforeMethod
    public void appLaunch() {
        driver = driverFactory.initDriver(prop); // ✅ PASS prop
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws InterruptedException {

        if (!result.isSuccess()) {
            ChainTestListener.embed(
                driverFactory.getScreenshotFile(),
                "image/png"
            );
        }
        Thread.sleep(2000);
        driver.quit();
        ChainTestListener.log("Browser closed ...");
    }
}

	
	



