//package tests;
//
//import com.google.common.collect.ImmutableMap;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class Base {
//    private IOSDriver<IOSElement> driver;
//    public void openDeepLinkForiOS(String deepLink) throws InterruptedException {
//        By safariURLBarSelector= By.xpath("//XCUIElementTypeTextField[@name='TabBarItemTitle']");
//        By safariURLTextSelector= By.xpath("//XCUIElementTypeTextField[@name='URL']");
//        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).findElement(safariURLBarSelector).click();
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(deepLink);
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(Keys.ENTER);
//        ((RemoteWebDriver) driver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//
////        try {
////            ((RemoteWebDriver) driver).findElement(By.id("Open")).click();
////        }catch (Exception e){
////            System.out.println("pop-up never displayed");
////        }
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    }
//
//}
