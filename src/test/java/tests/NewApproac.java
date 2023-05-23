package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NewApproac {
    private IOSDriver<IOSElement> driver;
//    String code = "123456"; // this code to be captured from mail

    @BeforeClass
    public void setup() throws MalformedURLException {
        String username = "aymansaeed_Ze8Ryp";
        String accessKey = "6X9hDsBUqeZga2SyYwqj";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //set session caps
        capabilities.setCapability("browserstack.user", username);
        capabilities.setCapability("browserstack.key", accessKey);
        capabilities.setCapability("browserstack.geoLocation", "GB");
        capabilities.setCapability("browserstack.gpsLocation", "51.509865,-0.118092");
        capabilities.setCapability("project", "MVA APP");
        capabilities.setCapability("build", "app store");
        capabilities.setCapability("name", "iOS");

        // Set  device capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        capabilities.setCapability("browserstack.geoLocation", "GB");
        capabilities.setCapability("app", "bs://713e188ba370c9f2655737c5913d912d665ed8bf");
        capabilities.setCapability("browserstack.appStoreConfiguration", new HashMap<String, String>() {{
            put("username", "uk.cover2023@gmail.com");
            put("password", "Test@42023");
            /**
             * uk.cover2023@gmail.com
             * Test@42023
             */
        }});

        // Initialize the driver
        driver = new IOSDriver<IOSElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000);
        driver.runAppInBackground(Duration.ofSeconds(-1));  // to send vodafone app to background
        Thread.sleep(1000);
        driver.activateApp("com.apple.AppStore");
        Thread.sleep(1000);

        By account = By.name("UIA.AppStore.AccountButton");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(account));
        driver.findElement(account).click();


        By appleId = By.name("Apple ID");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appleId));
            driver.findElement(appleId).sendKeys("uk.cover2023@gmail.com");

        By password = By.name("Password");
        driver.findElement(password).sendKeys("Test@42023");

        By signIn = By.name("Sign In");
        driver.findElement(signIn).click();
        Thread.sleep(2000);
//        for (int i = 0; i < code.length(); i++) {
//            By locator = By.xpath("//*[@name='passcodeDash' and @index='" + i + "']");
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            driver.findElement(locator).sendKeys(Keys.valueOf(Character.toString(code.charAt(i))));
//
//        }
        By locator = By.xpath("//XCUIElementTypeImage[@name='passcodeDash'][1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

//        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(code);
        Thread.sleep(2000);
        driver.runAppInBackground(Duration.ofSeconds(-1));  // to send vodafone app to background
        Thread.sleep(1000);
        driver.activateApp("com.apple.MobileSMS");
        Thread.sleep(1000);
        driver.runAppInBackground(Duration.ofSeconds(-1));  // to send vodafone app to background
        Thread.sleep(1000);
        driver.activateApp("com.apple.AppStore");
//

//
//        Thread.sleep(1000);
//        driver.runAppInBackground(Duration.ofSeconds(-1));  // to send  app store to background
//        Thread.sleep(1000);
//
//        openDeepLinkForiOS("https://apps.apple.com/gb/app/my-vodafone/id370901726");
//
//        By getAppCTA = By.name("UIA.AppStore.OfferButton");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(getAppCTA));
//        driver.findElement(getAppCTA).click();
//
//
//        By install = By.name("Install");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(install));
//        driver.findElement(install).click();
//
//        By password2 = By.xpath("//*[@value='Password']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(password2));
//        driver.findElement(password2).click();
//
//
//
//
//
//

    }

//    public void openDeepLinkForiOS(String deepLink) throws InterruptedException {
//        By safariURLBarSelector= By.xpath("//XCUIElementTypeTextField[@name='TabBarItemTitle']");
//        By safariURLTextSelector= By.xpath("//XCUIElementTypeTextField[@name='URL']");
//        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).findElement(safariURLBarSelector).click();
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(deepLink);
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(Keys.ENTER);
//        ((RemoteWebDriver) driver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


//        try {
//            ((RemoteWebDriver) driver).findElement(By.id("Open")).click();
//        }catch (Exception e){
//            System.out.println("pop-up never displayed");
//        }
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}