package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("LoginCredentials", 1, 0);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(profilePage.profileNameText(), validUsername);
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        for (int i = 1; i <= excelReader.getLastRow("LoginCredentials"); i++) {
            String invalidUsername = excelReader.getStringData("LoginCredentials", i, 2);
            String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
        }
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        for (int i = 1; i <= excelReader.getLastRow("LoginCredentials"); i++) {
            String invalidUsername = excelReader.getStringData("LoginCredentials", i, 2);
            String invalidPassword = excelReader.getStringData("LoginCredentials", i, 3);
            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage(), "Invalid username or password!");
        }
    }

}
