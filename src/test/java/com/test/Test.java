package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Elvina/AppData/Local/Google/Chrome/User Data");
        options.addArguments("profile-directory=Default"); // Replace 'Default' if another profile is used

        // Navigate to MetaMask extension (replace <MetaMask-Extension-ID>)
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");






    }
}
