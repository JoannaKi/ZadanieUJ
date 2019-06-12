package selenium.test.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EnvironmentsPage extends AbstractPage {

    @FindBy(xpath = "//html/body/div[1]/section/article/nav/ul/li/a")
    private WebElement addEnvironmentLink;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    @FindBy(id = "j_searchButton")
    private WebElement searchButton;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"content\"]/article/table/tbody")
    private WebElement table;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/button[1]")
    private WebElement yesDeleteButton;

    public EnvironmentsPage(WebDriver driver){
        super(driver);
    }

    public AddEnvironmentPage goToAddEnvironmentPage(){
        clickElement(addEnvironmentLink);
        return new AddEnvironmentPage(driver);
    }

    public void searchForEnvironment(String environmentName){
        fillField(searchField, environmentName);
        clickElement(searchButton);
    }

    public boolean isInfoBoxDisplayed(){
        return infoBox.isDisplayed();
    }

    public List<WebElement> getTableRows(WebElement baseTable){
        return baseTable.findElements(By.tagName("tr"));
    }

    public int getRowCount() {
        return getTableRows(table).size();
    }

    public void deleteForEnvironment(String envName) {
        clickElement(table.findElement(By.id("action_icon")));
        clickElement(table.findElement(By.className("j_delete_environment")));
        clickElement(yesDeleteButton);
    }
}