package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class googleMethods {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(groups = {"Smoke"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://google.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(groups = {"Smoke"})
    public void login() {
        driver.findElement(By.cssSelector("span[class = gb_Md]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("richardeng92@gmail.com");
        driver.findElement(By.xpath("//*[@id='identifierNext']/div/button")).click();
        driver.navigate().to("https://google.com");
    }

    @Test
    public void search() throws IOException {
        SoftAssert soft = new SoftAssert();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Fried Chicken");
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
        int amountofLinks = driver.findElements(By.tagName("a")).size();
        System.out.println(amountofLinks);
        List<WebElement> Links = driver.findElements(By.tagName("a"));
        for (WebElement link : Links) {
            String url = link.getAttribute("href");
            if (url != null) {
                HttpURLConnection connect = (HttpURLConnection) new URL(url).openConnection();
                connect.setRequestMethod("HEAD");
                connect.connect();
                int respCode = connect.getResponseCode();
                System.out.println(respCode);
                soft.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode);
            }
            else
            {
                System.out.println("No Link");
            }

           /* if (respCode > 400) {
                System.out.println("The link with Text " + link.getText()+" is broken with code " + respCode);
                a.assertTrue(false);*/
        }
        soft.assertAll();
        driver.quit();
        }

    }

