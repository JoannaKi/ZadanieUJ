package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage fillLoginForm (String login_field, String password ){
        driver.findElement(By.id("login_field")).sendKeys("JoannaKi");
        driver.findElement(By.id("password")).sendKeys("bedetesterem!!!1");
        return this;
    }

    public DashboardPage submitLoginForm(){
        driver.findElement(By.name("commit")).click();
        return new DashboardPage(driver);
    }

}
