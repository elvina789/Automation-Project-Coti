package com.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIStepsForMekorot {
    private final WebDriver driver;


    public UIStepsForMekorot() {

        driver = new ChromeDriver();
    }

    @Given("I go to Mekorot page")
    public void iOpenMekorotPage() {

        driver.get("https://www.mekorot-int.com/");
    }

    @When("I click on Mekorot menu")
    public void IClickOnMenu() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector("[class='svg-icon open']"));
        element.click();
    }

    @Then("I click on {string}")
    public void iClickOnAboutUsBy(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        element.click();
    }
}
