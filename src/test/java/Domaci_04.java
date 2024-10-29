import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Domaci_04 {

    //Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a,
    // dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
    //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu


    WebDriver driver;
    WebElement profile;
    WebElement bookStore;
    WebElement usernameField;
    WebElement passwordField;
    WebElement logInButton;
    Cookie cookieUsername;
    Cookie cookieUserID;
    Cookie cookieExpires;
    Cookie cookieToken;
    String validUsername, validPassword, loginURL, profileURL;
    WebDriverWait wait;
    JavascriptExecutor js;
    ArrayList<String> books = new ArrayList<>();

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        validUsername = "milica_r";
        validPassword = "Milica@223";
        profileURL = "https://demoqa.com/profile";
        loginURL = "https://demoqa.com/login";

        books.add("see-book-Git Pocket Guide");
        books.add("see-book-Learning JavaScript Design Patterns");
    }

    @BeforeMethod
    public void pageSetUp(){
        driver.get(loginURL);
    }

    @Test (priority = 10)
    public void addBooks() throws InterruptedException {
       cookieUsername = new Cookie("userName", validUsername);
       cookieUserID = new Cookie("userID", "24aa02b4-0bcf-41fd-bfea-d58bb7dace7c");
       cookieExpires = new Cookie("expires", "2024-01-28T12%3A08%3A10.490Z");
       cookieToken = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1pbGljYV9yIiwicGFzc3dvcmQiOiJNaWxpY2FAMjIzIiwiaWF0IjoxNzA1ODQwNjMzfQ.4xgBu9lb314z1mmF5c3tdPKQtJ9fTr9HxsWnUFcSpOE");

        driver.manage().addCookie(cookieUsername);
        driver.manage().addCookie(cookieUserID);
        driver.manage().addCookie(cookieExpires);
        driver.manage().addCookie(cookieToken);
        driver.navigate().to(profileURL);

        js.executeScript("window.scrollBy(0, 1000);");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("item-2")));

        bookStore = driver.findElement(By.id("gotoStore"));
        bookStore.click();


        for (String name : books){
            WebElement book = driver.findElement(By.id(name));
            book.click();

            js.executeScript("window.scrollBy(0, 1000);");
            WebElement addBook = driver.findElement(By.cssSelector(".text-right #addNewRecordButton"));
            addBook.click();

            driver.navigate().back();
        }

        driver.navigate().to(profileURL);
        driver.manage().deleteAllCookies();
        driver.navigate().to(loginURL);
    }

    @Test
    public  void CheckLogin(){
        usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(validUsername);
        passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);
        logInButton = driver.findElement(By.id("login"));
        logInButton.click();

        for (String name : books){
            WebElement book = driver.findElement(By.id(name));
            Assert.assertNotNull(book, "Book " + name + " not found!");
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
