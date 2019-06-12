package selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestClass {

 @Test
    public void test(){

     System.setProperty("webdriver.chrome.driver","C:\\Users\\Izochora\\Desktop\\Testowanie Oprogramowania\\automatyzacja_testów\\TestowanieUjProjekt-master\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();

     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.manage().window().maximize();

     driver.get("http://google.pl");

     Assert.assertEquals(driver.getTitle(), "Google");

     driver.quit();
 }
}
