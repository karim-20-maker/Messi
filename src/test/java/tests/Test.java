package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class Test {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", "Chrome");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("project", "Your Project Name");
        capabilities.setCapability("build", "Your Build Name");
        capabilities.setCapability("name", "Your Test Name");

        String username = "Your Username";
        String accessKey = "Your Access Key";
        String browserStackUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

        driver = new RemoteWebDriver(new URL(browserStackUrl), capabilities);
    }
}