package com.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiStepDefinitions {
    private final WebDriver driver;

    public UiStepDefinitions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
    }

    @Given("I go to Coti page")
    public void iOpencotiPage() {
        driver.get("https://treasury.coti.io");
    }

    @Then("I click on threasury button")
    public void iClickOnTreasury() {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[3]/button"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement treasuryButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        treasuryButton.click();
    }

    @Then("I click on metamask check box")
    public void iClickOnMetamaskCheckBox(){
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/div/div[2]/label/span"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(locator));
        checkBox.click();
    }

    @Then("I click on metamask select button")
    public void iClickOnMetamaskSelectButton(){
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/button"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        selectButton.click();
    }

    @Then("I click on terms of conditions")
    public void iClickOnTermsOfConditions(){
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/div/div[2]/div/a"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement termsButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        termsButton.click();
    }

    @Then("Terms of use are valid")
    public void termsOfConditionsAreValid(){
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div/h1"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement termsHeader = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Assertions.assertEquals("TERMS OF USE", termsHeader.getText(), "Incorrect terms message");
    }

    @Then("I close Coti page")
    public void iCloseCotiPage() {
        driver.close();
    }
}
