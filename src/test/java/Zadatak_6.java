import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak_6 {
    public static void main(String[] args) {

        //Testirati log out funkcionalnost

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/logged-in-successfully/");

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement logOutElement = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        logOutElement.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

       // WebElement title = driver.findElement(By.className("post-title"));
       // Assert.assertEquals(actualTitle, expectedTitle);

        WebElement linkText = driver.findElement(By.linkText("Log out"));
       // Assert.assertTrue(logOutButton.isDisplayed());

        WebElement welcomeText = driver.findElement(By.className("has-text-align-center"));
        Assert.assertEquals(welcomeText.getText(),"Congratulations "+validUsername+". You successfully logged in!");
    }
}
