package com.test.steps;

import io.cucumber.java.en.And;
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
import java.util.UUID;

public class UiStepDefinitions {

    private final WebDriver driver;

    public UiStepDefinitions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-blink-features=AutomationControlled");
        options.addExtensions(new java.io.File("C:\\MetamaskCrx\\NKBIHFBEOGAEAOEHLEFNKODBEFGPGKNN_12_8_0_0.crx"));
        options.addArguments("user-data-dir=C:/Users/Elvina/AppData/Local/Google/Chrome/User Data\\Profile 1");
        options.addArguments("profile-directory=Profile 1"); // Replace 'Default' if another profile is used

        driver = new ChromeDriver(options);

    }

    @Given("I go to Coti page")
    public void iOpencotiPage() throws InterruptedException {
        driver.get("https://treasury.coti.io");
        Thread.sleep(3000);
    }

    @Then("I click on treasury button")
    public void iClickOnTreasury() {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[3]/button"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement treasuryButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        treasuryButton.click();
    }
    @Then("I click on enter treasury button")
    public void iClickOnEnterTreasury() throws InterruptedException {
        Thread.sleep(5000);
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[3]/button"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement treasuryButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        treasuryButton.click();
        Thread.sleep(1000);
    }

    @Then("I click on metamask check box")
    public void iClickOnMetamaskCheckBox() throws InterruptedException {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/div/div[2]/label/span"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(locator));
        checkBox.click();
        Thread.sleep(2000);

    }

    @Then("I click on metamask select button")
    public void iClickOnMetamaskSelectButton() throws InterruptedException {
        Thread.sleep(2000);

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");


// Agree to terms (if any)
        WebElement agreeButton = driver.findElement(By.id("onboarding__terms-checkbox"));
        agreeButton.click();
        Thread.sleep(2000);


        // Click "Import Wallet"
        WebElement importWalletButton = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/ul/li[3]/button"));
        importWalletButton.click();
        Thread.sleep(2000);


        // Click on I  agree to terms
        WebElement iAgreeToTerms = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button[2]"));
        iAgreeToTerms.click();
        Thread.sleep(2000);


        WebElement iInser0Word = driver.findElement(By.id("import-srp__srp-word-0"));
        iInser0Word.click();
        iInser0Word.sendKeys("laundry");
        Thread.sleep(2000);


        WebElement iInsert1Word = driver.findElement(By.id("import-srp__srp-word-1"));
        iInsert1Word.click();
        iInsert1Word.sendKeys("wedding");
        Thread.sleep(2000);


        WebElement iInsert2Word = driver.findElement(By.id("import-srp__srp-word-2"));
        iInsert2Word.click();
        iInsert2Word.sendKeys("galaxy");
        Thread.sleep(2000);


        WebElement iInsert3Word = driver.findElement(By.id("import-srp__srp-word-3"));
        iInsert3Word.click();
        iInsert3Word.sendKeys("bachelor");
        Thread.sleep(2000);


        WebElement iInsert4Word = driver.findElement(By.id("import-srp__srp-word-4"));
        iInsert4Word.click();
        iInsert4Word.sendKeys("sword");
        Thread.sleep(2000);


        WebElement iInsert5Word = driver.findElement(By.id("import-srp__srp-word-5"));
        iInsert5Word.click();
        iInsert5Word.sendKeys("someone");
        Thread.sleep(2000);


        WebElement iInsert6Word = driver.findElement(By.id("import-srp__srp-word-6"));
        iInsert6Word.click();
        iInsert6Word.sendKeys("woman");
        Thread.sleep(2000);



        WebElement iInsert7Word = driver.findElement(By.id("import-srp__srp-word-7"));
        iInsert7Word.click();
        iInsert7Word.sendKeys("remove");
        Thread.sleep(2000);



        WebElement iInsert8Word = driver.findElement(By.id("import-srp__srp-word-8"));
        iInsert8Word.click();
        iInsert8Word.sendKeys("tank");
        Thread.sleep(2000);


        WebElement iInsert9Word = driver.findElement(By.id("import-srp__srp-word-9"));
        iInsert9Word.click();
        iInsert9Word.sendKeys("above");
        Thread.sleep(2000);


        WebElement iInsert10Word = driver.findElement(By.id("import-srp__srp-word-10"));
        iInsert10Word.click();
        iInsert10Word.sendKeys("foam");
        Thread.sleep(2000);


        WebElement iInsert11Word = driver.findElement(By.id("import-srp__srp-word-11"));
        iInsert11Word.click();
        iInsert11Word.sendKeys("lecture");

        Thread.sleep(2000);
    }

    @Then("I click on terms of conditions")
    public void iClickOnTermsOfConditions() {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/div/div[2]/div/a"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement termsButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        termsButton.click();
    }

    @Then("Terms of use are valid")
    public void termsOfConditionsAreValid() {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div/h1"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement termsHeader = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Assertions.assertEquals("TERMS OF USE", termsHeader.getText(), "Incorrect terms message");
    }

    @Then("I close Coti page")
    public void iCloseCotiPage() {
//        driver.close();
    }

    @Then("I click on confirm button on metamask")
    public void iClickOnConfirmButtonOnMetamask() {

        WebElement confirm = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[4]/div/button"));
        confirm.click();
    }

    @Then("I receive message that service is unavailable")
    public void iReceiveMessageThatServiceIsUnavailable() {
        By locator = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/p"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement serviceMessage = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Assertions.assertEquals("TERMS OF USE", serviceMessage.getText(), "This service is unavailable in your jurisdiction");
    }

    @Then("I insert new password")
    public void iInsertEmailAndPassword() throws InterruptedException {
//        Thread.sleep(2000);
//        String password = UUID.randomUUID().toString();
//        WebElement iInsertPassword= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div[1]/label/input"));
//        iInsertPassword.click();
//        iInsertPassword.sendKeys(password);
//        WebElement confirmPassword= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div[2]/label/input"));
//        confirmPassword.click();
//        confirmPassword.sendKeys(password);


        Thread.sleep(2000);
        WebElement iInsertPassword= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div[1]/label/input"));
        iInsertPassword.click();
        iInsertPassword.sendKeys("PinkLove789");
        WebElement confirmPassword= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div[2]/label/input"));
        confirmPassword.click();
        confirmPassword.sendKeys("PinkLove789");
    }

    @And("I click on checkbox")
    public void iClickOnCheckbox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clickOnCheckbox= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[3]/label/span[1]/input"));
        clickOnCheckbox.click();
    }

    @And("i click on import my wallet")
    public void iClickOnImportMyWallet() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clickOnCheckbox= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/button"));
        clickOnCheckbox.click();
    }

    @And("I click on done")
    public void iClickOnDone() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clickOnDone= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[3]/button"));
        clickOnDone.click();
    }

    @And("i click on next")
    public void iClickOnNext() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clickOnNext= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button"));
        clickOnNext.click();
        Thread.sleep(2000);
        WebElement clickOnDone= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button"));
        clickOnDone.click();
    }

    @And("I click on coti select button")
    public void iClickOnCotiSelectButton() throws InterruptedException {
//        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");
        By locator = By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[5]/div/div[2]/div[1]/button"); // Using XPATH only for example, we can always choose a stronger selector
        // Define the timeout duration for waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        selectButton.click();
        Thread.sleep(1000);

    }

    @And("I go to metamask wallet")
    public void iGoToMetamaskWallet() throws InterruptedException {
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");
    }

    @And("I insert password")
    public void iInsertPassword() throws InterruptedException {
        Thread.sleep(7000);
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().contains("MetaMask")) {
                System.out.println("Switched to MetaMask window.");
                break;
            }
        }
        WebElement insertPassword= driver.findElement(By.id("password"));
        Thread.sleep(1000);
        insertPassword.click();
        Thread.sleep(1000);
        insertPassword.sendKeys("PinkLove789");
    }

    @And("I click on unlock")
    public void iClickOnUnlock() {
        WebElement iClickOnUnlock= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/button"));
        iClickOnUnlock.click();
    }

    @And("I reload the page")
    public void iReloadThePage() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh(); // Reload the page
        Thread.sleep(3000);
    }
}

