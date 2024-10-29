import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_10 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 10
    //Otici na stranicu https://imgflip.com/memegenerator
    //Uploadovati sliku od koje treba napraviti mim
    //Mim mora biti vezan za IT, QA ili kurs
    //Sliku rucno skinuti i ubaciti na Slack thread poruku
    //Autor mima sa najvise lajkova dobija pivo na druzenju
    //
    //Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://imgflip.com/memegenerator");

        Thread.sleep(3000);
        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();



    }
}
