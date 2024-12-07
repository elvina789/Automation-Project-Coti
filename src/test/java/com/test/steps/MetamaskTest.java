package com.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MetamaskTest {
    public static void main(String[] args) {
        // MetaMask configuration
        final WebDriver driver;
        String mnemonic = "security curve swallow few tilt attract donor tuition matter place spoon major";
        String password = "11111111";

        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-blink-features=AutomationControlled");
        options.addExtensions(new java.io.File("C:\\MetamaskCrx\\NKBIHFBEOGAEAOEHLEFNKODBEFGPGKNN_12_8_0_0.crx"));
        options.addArguments("user-data-dir=C:/Users/Elvina/AppData/Local/Google/Chrome/User Data\\Profile 1");
        options.addArguments("profile-directory=Profile 1"); // Replace 'Default' if another profile is used

        driver = new ChromeDriver(options);

        // Initialize WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            // Switch to MetaMask tab
            driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

            // Click "Import Wallet" button
            WebElement importWalletButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/button[1]")));
            importWalletButton.click();

            // Enter mnemonic phrase
            for (int i = 0; i < 12; i++) {
                WebElement wordInput = driver.findElement(By.id("import-srp__srp-word-" + i));
                wordInput.sendKeys(mnemonic.split(" ")[i]);
            }

            // Set password
            WebElement passwordInput = driver.findElement(By.id("create-password"));
            WebElement confirmPasswordInput = driver.findElement(By.id("confirm-password"));
            WebElement agreeCheckbox = driver.findElement(By.className("first-time-flow__checkbox"));
            WebElement importButton = driver.findElement(By.xpath("//button[@data-testid='import-srp-confirm']"));

            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys(password);
            agreeCheckbox.click();
            importButton.click();

            System.out.println("Wallet imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
//            driver.quit();
        }
    }
}

