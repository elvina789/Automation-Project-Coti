package com.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UISteps2 {
    public final WebDriver driver;


    public UISteps2() {
        driver = new ChromeDriver();
    }


    public static void main(String[] args) throws InterruptedException {
        UISteps2 uiSteps2 = new UISteps2();
        uiSteps2.goToGitPage();
        uiSteps2.IClickOnSearchButton();

    }

    public void goToGitPage() {
        driver.get("https://github.com/");
    }

    public void IClickOnSearchButton() throws InterruptedException {
        By locator = By.cssSelector("[class='search-input-container search-with-dialog position-relative d-flex flex-row flex-items-center mr-4 rounded']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        Thread.sleep(3000);
        element.sendKeys("laundry");

    }
}
