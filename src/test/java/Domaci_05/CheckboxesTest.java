package Domaci_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void PageSetUp() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void CheckBoxesSelected() {
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkbox1.click();

        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        checkbox2.click();
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    public void check (WebElement checkbox) {
        if(!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public void uncheck (WebElement checkbox) {
        if(checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
