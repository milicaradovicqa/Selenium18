import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_7 {
    public static void main(String[] args) {

        //Testirati neuspesan log in

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("incorrectUser");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement username2 = driver.findElement(By.id("username"));
        username2.click();
        username2.sendKeys("student");
        WebElement password2 = driver.findElement(By.id("password"));
        password2.click();
        password2.sendKeys("incorrectPassword");
        WebElement submitButton2 = driver.findElement(By.id("submit"));
        submitButton2.click();

        WebElement submitButton3 = driver.findElement(By.id("submit"));
        submitButton3.click();

        WebElement username4 = driver.findElement(By.id("username"));
        username4.click();
        username4.sendKeys("student");
        WebElement submitButton4 = driver.findElement(By.id("submit"));
        submitButton4.click();

        WebElement password5 = driver.findElement(By.id("password"));
        password5.click();
        password5.sendKeys("Password123");
        WebElement submitButton5 = driver.findElement(By.id("submit"));
        submitButton5.click();



    }
}
