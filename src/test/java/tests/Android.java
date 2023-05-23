package tests;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;


public class Android {
    private AndroidDriver driver;


    @BeforeClass
    public void setUp() throws Exception {
        String username = "aymansaeed_Ze8Ryp";
        String accessKey = "6X9hDsBUqeZga2SyYwqj";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //set session caps
        capabilities.setCapability("browserstack.user", username);
        capabilities.setCapability("browserstack.key", accessKey);
        capabilities.setCapability("project", "MVA APP");
        capabilities.setCapability("build", "google play");
        capabilities.setCapability("name", "Android");

        // Set  device capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 9");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("deviceOrientation", "portrait");

        capabilities.setCapability("browserstack.appStoreConfiguration", new HashMap<String, String>() {{
            put("username", "uk.cover2023@gmail.com");
            put("password", "Uk@42023");
        }});
        capabilities.setCapability("browserstack.geoLocation", "GB");
        /**
         * make sure to use Android  build from dev branch
         */
//        capabilities.setCapability("app","bs://972d362aa1e5bfd3bd6ef9b7f466b5c034e266d0");
        capabilities.setCapability("app", "bs://172103454857953fd6d3307bf328cc4dfe12c039");



// Initialize the driver
        driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

    }

    @Test
    public void testAppInstallation() throws InterruptedException {
        System.out.println("open app successfully!");
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME)); // send app to background
        Thread.sleep(2000);
        /**
         * next 3 lines to open google play using our app deeplink
         */
        Activity activity = new Activity("com.android.vending",
                "com.android.vending.AssetBrowserActivity");
        activity.setOptionalIntentArguments("market://details?id=com.myvodafoneapp");
        driver.startActivity(activity);
        Thread.sleep(2000);
        System.out.println("navigated to Google play store  using MV deep link successfully");
        System.out.println(driver.getPageSource()); // for locators u can comment it
        By install = By.xpath("(//android.widget.Button)[4]"); // u can set both locators into find all start with long one
        By install2 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.Button");
        driver.findElement(install2).click();
        Thread.sleep(20000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
         activity = new Activity("com.myvodafoneapp",
                "com.tsse.vfuk.view.VFLaunchActivity");
        driver.startActivity(activity);
        Thread.sleep(5000);

        By continu = By.id("com.myvodafoneapp:id/btn_continue");
        driver.findElement(continu).click();
        Thread.sleep(2000);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
/**
 * devices             | OS
 * Google Pixel 6      | 12.0
 * Samsung Galaxy S21" | 11
 * Samsung Galaxy S22" | 12
 * OnePlus 9           | 11
 */