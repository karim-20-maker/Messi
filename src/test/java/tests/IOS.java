package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IOS {
    private IOSDriver<IOSElement> driver;
    @BeforeClass
    public void setUp() throws Exception {
        String username = "aymansaeed_Ze8Ryp";
        String accessKey = "6X9hDsBUqeZga2SyYwqj";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //set session caps
        capabilities.setCapability("browserstack.user", username);
        capabilities.setCapability("browserstack.key", accessKey);
        capabilities.setCapability("project", "MVA APP");
        capabilities.setCapability("build", "app store");
        capabilities.setCapability("name", "iOS");

        // Set  device capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        capabilities.setCapability("app", "bs://06d488f1d196c8d9fff769c4edca1f33b989063e");
        capabilities.setCapability("bundleId", "com.vodafone.myvodafoneuk");

            /**
             * uk.cover2023@gmail.com
             * Test@42023
             */
//        }});

        // Initialize the driver
        driver = new IOSDriver<IOSElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }
    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }


    }
    @Test
    public void lunchApp() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("live app is here ");
        System.out.println("second commit");
    }


}
/**
 * account icon : 	UIA.AppStore.AccountButton name
 * apple id : 	Apple ID name
 * password : Password name
 * code : 	passcodeDash   name index from 0 to 5
 * done after login and install no locators for them
 */