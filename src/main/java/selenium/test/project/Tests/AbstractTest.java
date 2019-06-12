package selenium.test.project.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        // Wskazanie zewnętrznego pliku drivera dla przeglądarki CHROME
        String os = System.getProperty("os.name").toLowerCase();
        if ( os.indexOf("mac") >= 0 ) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    "../chromedriver"
            );
        } else if ( os.indexOf("win") >= 0 ){
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\Users\\Izochora\\Desktop\\Testowanie Oprogramowania\\automatyzacja_testów\\TestowanieUjProjekt-master\\chromedriver.exe"
            );
        }
        //Stworzenie i zainicjalizowanie obiektu DRIVER przeglądarką CHROME
        driver = new ChromeDriver();
        // Ustawienie globalnego timeouta na 5 sekund
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Ustawienie zmaksymalizowanego okna
        driver.manage().window().maximize();
        // przejście na wskazaną stronę
        driver.get("http://demo.testarena.pl");
    }

    @AfterSuite
    public void tearDownSuite() {
        //Zamknięcie przeglądarki
        driver.quit();
    }
}
