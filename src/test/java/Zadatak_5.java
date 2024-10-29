import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak_5 {
    public static void main(String[] args) {

        // Testirati log in stranice https://practicetestautomation.com/
        // 5.2 Dodati asertacije nakon logovanja

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

       driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();
       //WebElement username = driver.findElement(By.linkText("Test Login Page");

        WebElement username = driver.findElement(By.id("username"));


        username.click();
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("post-title"));
        String pageTitleText = pageTitle.getText();

        String expectedTitle = "Logged In Successfully";

        Assert.assertEquals(pageTitleText, expectedTitle);



    }
}
