package Domaci_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagesTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void pageSetUp(){
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }
    @Test
    public void imagesLoaded () {
        List<WebElement> images = driver.findElements(By.cssSelector("img"));
        for (WebElement image : images){
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println(image.getAttribute("outerHTML") + "is broken.");
            }
        }

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
