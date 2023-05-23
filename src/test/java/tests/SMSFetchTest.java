package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class SMSFetchTest {

    private IOSDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.5");
        capabilities.setCapability("deviceName", "iPhone 11");
        capabilities.setCapability("app", "com.apple.MobileSMS");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new IOSDriver<>(url, capabilities);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFetchSMS() {
        // Wait for the messaging app to load
        MobileElement conversationList = driver.findElementByAccessibilityId("Conversation List");

        // Click the most recent conversation
        List<MobileElement> conversationCells = conversationList.findElementsByClassName("XCUIElementTypeCell");
        conversationCells.get(0).click();

        // Wait for the conversation to load
        MobileElement conversationView = driver.findElementByAccessibilityId("Conversation");

        // Fetch the most recent message and extract its body
        List<MobileElement> messageCells = conversationView.findElementsByClassName("XCUIElementTypeCell");
        MobileElement message = messageCells.get(0);
        MobileElement messageBody = message.findElementByAccessibilityId("Message Text");
        String bodyText = messageBody.getText();

        // Print the message body to the console
        System.out.println("Most recent message body: " + bodyText);
    }
}
