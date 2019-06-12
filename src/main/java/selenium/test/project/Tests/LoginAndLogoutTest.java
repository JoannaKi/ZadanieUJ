package selenium.test.project.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.project.Pages.DashboardPage;
import selenium.test.project.Pages.LoginPage;

public class LoginAndLogoutTest extends AbstractTest {

    @Test(groups = "login")
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("administrator@testarena.pl", "sumXQQ72$L");

        DashboardPage dashboardPage = loginPage.submitLoginForm();

        Assert.assertTrue(
                dashboardPage.isLogoutButtonDisplayed()
        );
    }

    @Test(dependsOnGroups = "login")
    public void successLogoutTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        dashboardPage.logout();

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed()
        );
    }
}