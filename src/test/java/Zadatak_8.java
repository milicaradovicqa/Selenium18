import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak_8 {
    public static void main(String[] args) throws InterruptedException {
        //Testirati log in na wordpress stranicu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        String username = "milicaradovicqa";
        usernameField.sendKeys(username);

        // button - type - submit
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("zimA028#");

        continueButton.click();

        //Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/milicaradovicqa.wordpress.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/milicaradovicqa.wordpress.com");

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("profile-gravatar__user-display-name"))));

        WebElement usernameTitle = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String usernameText = usernameTitle.getText();

        Assert.assertEquals(usernameText, username);

        Cookie cookie = new Cookie("wordpress_logged_in","milicaradovicqa%7C1800042377%7C1LOYNqyuDlBNTbFog9OFiEkfSpwFVhU3Y43XfVDyty8%7C76b5a9687c99219d7bc9c76acbe877b6f3bcdcdc3ddf18e8df4a9d035d199fcc");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(4000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();





    }
}
