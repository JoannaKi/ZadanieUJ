package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SecondTestClass {



        WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Wskazanie zewnętrznego pliku drivera dla przeglądarki CHROME
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\Users\\zp114298\\Desktop\\chromedriver.exe"
            );
            //Stworzenie i zainicjalizowanie obiektu DRIVER przeglądarką CHROME
            driver = new ChromeDriver();
            // Ustawienie globalnego timeouta na 5 sekund
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            // Ustawienie zmaksymalizowanego okna
            driver.manage().window().maximize();
            // przejście na wskazaną stronę
            driver.get("http://demo.testarena.pl");
        }

        @Test
        public void successLoginTest() {
            driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
            driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
            driver.findElement(By.id("login")).click();

            Assert.assertTrue(
                    driver.findElement(
                            By.xpath(
                                    "//html/body/header/div[2]/div[2]/a/span"
                            )
                    ).isDisplayed()
            );
        }

        @AfterClass
        public void tearDown()
        {
            //Zamknięcie przeglądarki
            driver.quit();
        }
    }

