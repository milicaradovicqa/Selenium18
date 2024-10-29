import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {
        //Stari nacin kako smo ucitavali chrome driver
        //Morali smo chromedriver.exe file da skinemo i smestimo u odredjeni folder
        //Nakon toga komanda setProperty bi citala taj fajl
        //Postojao je problem kod odjedjenih operativnih sistema gde je antivirus brisao ovaj fajl
        //i testovi bi padali jer fajl vise ne postoji pa ste morali da podesavate 'exception' za file

        //System.setProperty("webdrive.chrome.driver", driver-lib//chromedriver.exe")

        //Ovu komandu koristimo da podesimo chromedriver iz biblioteke koju smo uneli u pom fajl
        //Na pocetku klase mozete fideti:
        //import io.github.bonigarcia.wdm.WebDriverManager;
        //To je ona treca biblioteka koju smo ubacili u pom fajl
        //Kada setujemo chromedriver potrebno je da napravimo objekat sa kojim cemo raditi
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //Komanda navigate().to() nam otvara zeljeni URL
        //Obratite paznju koju URL ubacujete
        //Ako link NIJE podvucen kao u ovom primeru, onda znaci da link nije validan
        driver.navigate().to("https://www.google.com");
        //Sledeca komanda je za povecanje prozora u kom radimo
        //Slicna komanda je manage().window().fullscreen()
        driver.manage().window().maximize();
        //Drugi nacin kako da odete na zeljeni URL je preko get() metode
        driver.get("https://www.youtube.com");

        //Razlike izmedju navigate i get mozete naci na narednom linku:
        //https://www.baeldung.com/selenium-webdriver-get-vs-navigate#:~:text=And%20because%20it's%20just%20an,driver.


        //Komanda za stampanje trenutno URL-a
        //Imajte u vidu da URL moze da se razlikuje od unetog iz prethodnog koraka
        System.out.println(driver.getCurrentUrl());


        //Komanda za refresh
        driver.navigate().refresh();
        //Komanda za vracanje na prethodnu stranicu
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl());
        //Komanda za odlazak na narednu stranicu
        driver.navigate().forward();

        driver.quit();  //stavljamo kada zelimo da zatvorimo browser, kada zavrsimo testiranje i vidimo da je sve ok
        driver.close(); // ovaj driver ce da zatvori trenutni tab na kojem se nalazi

        //quit() metoda se ostavlja za sam kraj i ona ce da ugasi browser u kome se radilo
        //Dok pravite testove nemojte da pisete tu metodu jer kao QA zelite da vidite sta vam
        //program radi, odnosno sta se testira
        //Tek kada ste sigurni da vam je test gotov i sve radi kako treba, onda koristite ovu metodu
        //driver.close();
        //close() metoda zatvara trenutni tab koji vam je otvoren
        //Ako radite u jednom tabu i na ovaj nacin zatvorite browser onda cete imati problema
        //sa testovima jer ce program cekati odgovor
    }
}
