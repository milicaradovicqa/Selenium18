package Domaci_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Negativan_logIn_5 {
    public static void main(String[] args) {

        // Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement nameField = driver.findElement(By.id("form_first_name_7"));
        nameField.sendKeys("Pera");
        WebElement submitButton = driver.findElement(By.className("mailpoet_submit"));
        submitButton.click();

        WebElement emailField = driver.findElement(By.id("form_email_7"));
        emailField.sendKeys("pera4567%");
        WebElement submitButton2 = driver.findElement(By.className("mailpoet_submit"));
        submitButton.click();

        WebElement pageText = driver.findElement(By.className("parsley-type"));
        String pageTextText = pageText.getText();

        String expectedText ="This value should be a valid email.";
        Assert.assertEquals(pageTextText, expectedText);

    }
}
