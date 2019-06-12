package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    public String isJoannaKiDisplayd(){
        return driver.findElement(
                By.xpath(
                        "//html/body/div[4]/div/aside[1]/div[2]/div/div/ul/li/div/a/span[1]"
                )
        ).getText();

    }


}
