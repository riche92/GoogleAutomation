package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class googleMethods {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }
    @Test(groups = {"Smoke"})
        public void login(){
        driver.findElement(By.cssSelector("span[class = gb_Md]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("richardeng92@gmail.com");
        driver.findElement(By.xpath("//*[@id='identifierNext']/div/button")).click();
        driver.navigate().to("https://google.com");
        }
        @Test
        public void search(){
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Fried Chicken");


        }
    }
