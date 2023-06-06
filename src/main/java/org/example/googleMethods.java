package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class googleMethods {
    WebDriver driver;
    @Test
        public void login(){
            System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://google.com");
            driver.findElement(By.cssSelector("span[class = gb_Md]")).click();
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("richardeng92@gmail.com");
        }

        public void search(){

        }
    }
