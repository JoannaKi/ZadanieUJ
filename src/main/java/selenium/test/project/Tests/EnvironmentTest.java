package selenium.test.project.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.test.project.Pages.AddEnvironmentPage;
import selenium.test.project.Pages.DashboardPage;
import selenium.test.project.Pages.EnvironmentsPage;
import selenium.test.project.Pages.LoginPage;

import java.util.Date;

public class EnvironmentTest extends AbstractTest {

    private DashboardPage dashboardPage;
    private String envName = "Environment_" + new Date().getTime();

    @BeforeTest
    public void successLoginTest() {
        dashboardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("administrator@testarena.pl", "sumXQQ72$L");

        DashboardPage dashboardPage = loginPage.submitLoginForm();

        Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());
    }

    @Test(groups = "a")
    public void successAddEnvironmentTest() {
        // Wejście w środowiska
        EnvironmentsPage environmentsPage = dashboardPage.goToEnvironmentsPage();
        // Wejscie w dodawanie środowiska
        AddEnvironmentPage addEnvironmentPage = environmentsPage.goToAddEnvironmentPage();
        // Uzupełnienie formularza
        addEnvironmentPage = addEnvironmentPage.fillAddEnvironmentForm(envName, "description");

        // Wysłąnie formularza
        environmentsPage = addEnvironmentPage.submitAddEnvironmentForm();

        // Sprawdzenie czy dodano
        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
    }

    @Test(groups = "b", dependsOnGroups = "a")
    public void successSearchEnvironmentTest() {
        // Wejście w środowiska
        EnvironmentsPage environmentsPage = dashboardPage.goToEnvironmentsPage();

        //Search
        environmentsPage.searchForEnvironment(envName);

        // Sprawdzenie czy znaleziono tylko jedną linijkę
        Assert.assertEquals(environmentsPage.getRowCount(), 1);
    }

    @Test(dependsOnGroups = "b")
    public void successDeleteEnvironmentTest() {
        // Wejście w środowiska
        EnvironmentsPage environmentsPage = dashboardPage.goToEnvironmentsPage();

        //Search & Delete
        environmentsPage.searchForEnvironment(envName);
        environmentsPage.deleteForEnvironment(envName);

        // Sprawdzenie czy usunęło
        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
    }

}
