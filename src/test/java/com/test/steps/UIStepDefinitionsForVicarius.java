package com.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIStepDefinitionsForVicarius {
    private final WebDriver driver;

    public UIStepDefinitionsForVicarius() {
        driver = new ChromeDriver();
    }

    @Given("I go to github page")
    public void IGoToGithubPage() {
        driver.get("https://github.com/");
    }


//    @When("I click on the search button")
//    public void iClickOnTheSearchButton() {
////        By locator = By.cssSelector("[class='search-input-container search-with-dialog position-relative d-flex flex-row flex-items-center mr-4 rounded']");
//        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='search-input-container search-with-dialog position-relative d-flex flex-row flex-items-center mr-4 rounded']")));
//        element.click();
//        element.sendKeys("ElvinaFinalSpringProject");
//    }

    @Then("I search for {string} repository")
    public void iSearchForRepository(String repoName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement clickOnSearchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='search-input-container search-with-dialog position-relative d-flex flex-row flex-items-center mr-4 rounded']")));
        clickOnSearchButtonElement.click();
        WebElement clickToInsertWordButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  //*[@id=\"query-builder-test\"]")));
        clickToInsertWordButton.click();
        clickOnSearchButtonElement.sendKeys(repoName);
        WebElement elementSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='ActionListContent ActionListContent--visual16 QueryBuilder-ListItem']")));
        elementSearch.click();
    }
}
