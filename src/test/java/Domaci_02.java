import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IExecutionListener;

public class Domaci_02 {
    public static void main(String[] args) throws InterruptedException {
        //https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String expectedURL = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Petar Petrovic");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("pera.pera@yahoo.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Topolska 18");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Soba podstanara");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement name = driver.findElement(By.id("name"));
        String nameText = name.getText();

        WebElement email = driver.findElement(By.id("email"));
        String emailText = name.getText();









    }
}
