package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GetCode {
    WebDriver driver ;
    String email = "karim.ahmed_200@yahoo.com";
    String password = "200karim200";


        @BeforeTest
        public void setup () {
            // Setup ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            // Setup WebDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

        @Test
        public void testYahooEmail () {
            // Navigate to Yahoo
            driver.get("https://www.yahoo.com/");

            // Click the Mail icon to go to Yahoo Mail
            WebElement mailIcon = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
            mailIcon.click();

            WebElement emailInput = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));

            emailInput.sendKeys(email);
            WebElement nextButton = driver.findElement(By.id("login-signin"));
            nextButton.click();

            // Enter Yahoo password and click Sign In
            WebElement passwordInput = driver.findElement(By.id("login-passwd"));
            passwordInput.sendKeys(password);
            WebElement signInButton = driver.findElement(By.id("login-signin"));
            signInButton.click();

            // Wait for the inbox page to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Click the latest email and retrieve its text
            WebElement latestEmail = driver.findElement(By.cssSelector(".qZ0"));
            String latestEmailText = latestEmail.getText();
            System.out.println("Latest email: " + latestEmailText);

            // Verify that the latest email is not empty
            Assert.assertFalse(latestEmailText.isEmpty());
        }


//        @AfterTest
//        public void teardown() {
//            // Close the browser
//            driver.quit();
//        }
    }