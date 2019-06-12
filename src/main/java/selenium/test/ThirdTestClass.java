package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThirdTestClass {
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
        driver.get("https://github.com/login");
    }

    @Test
    public void successLoginTest() {
        driver.findElement(By.id("login_field")).sendKeys("JoannaKi");
        driver.findElement(By.id("password")).sendKeys("bedetesterem!!!1");
        driver.findElement(By.name("commit")).click();

        Assert.assertEquals(
                driver.findElement(
                        By.xpath(
                                "//html/body/div[4]/div/aside[1]/div[2]/div/div/ul/li/div/a/span[1]"
                        )
                ).getText(),"JoannaKi"
        );
    }

    @AfterClass
    public void tearDown()
    {
        //Zamknięcie przeglądarki
        driver.quit();
    }
}


