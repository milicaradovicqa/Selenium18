package Domaci_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void option1SholuldBeSelected(){
        WebElement select = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(select);


        dropdown.selectByVisibleText("Option 1");

        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 1']")).isSelected());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
