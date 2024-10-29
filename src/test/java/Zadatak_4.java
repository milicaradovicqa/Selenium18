import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak_4 {
    public static void main(String[] args) {

        //Otici na Google
        //Zatim ukucati "Wikipedia" u polje za pretragu
        //Odraditi pretragu i otvoriti stranicu
        //Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com/");

        WebElement searshBox = driver.findElement(By.name("q"));
        searshBox.sendKeys("Wikipedia");

        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(0).click();

        // Pogresan nacin
       // WebElement wikipediaLink = driver.findElement(By.className("LC20lb MBeuO DKV0Md"));
        WebElement wikipediaLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));

        wikipediaLink.click();

        WebElement wikipediaSearch = driver.findElement(By.id("searchInput"));

        wikipediaSearch.sendKeys("Nikola Tesla");

        //WebElement wikipediaButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='sybmit']"));
        wikipediaButton.click();

        //--------------------------------------------

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        //Kada koristimo assertEquals - sa leve strane je REALAN rezultat, sa desne strane je OCEKIVAN rezultat
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String pageTitleText = pageTitle.getText();
        //ovaj String iznad ce izvuci tekst iz web elementa iznad Stringa

        String expectedTitle ="Nikola Tesla";

        Assert.assertEquals(pageTitleText, expectedTitle);

        //provera da li je slika prisutna na stranici
        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed());
        //Assert.assertFalse(pageImage.isDisplayed()); - da proverimo da li je test validan, promenimo True u False







    }
}
