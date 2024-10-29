import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3_2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys("Wikipedia");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"))
                .click();

        driver.findElement(By.xpath("/html/body/div[5]/div/div[9]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
                .click();

        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"))
                .sendKeys("Nikola Tesla");

        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/button"))
                .click();

    }
}
