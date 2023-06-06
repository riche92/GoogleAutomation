package org.example;

public class GoogleMain {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
        googleMethods Google = new googleMethods();
        Google.login();
        Google.search();


    }
}