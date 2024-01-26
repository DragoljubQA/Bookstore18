package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class AddBookTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        sidebarPage = new SidebarPage();
        booksPage = new BooksPage();
        bookPage = new BookPage();

        String validUsername = excelReader.getStringData("LoginCredentials", 1, 0);
        String validPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCanAddBook() {
        //Assert.assertFalse(elementIsDisplayed(profilePage.booksInProfile.get(0)));

        //Assert.assertEquals(profilePage.booksInProfile.size(), 0);
        Assert.assertTrue(profilePage.booksInProfile.isEmpty());
        sidebarPage.clickOnButton("Book Store");
        wait.until(ExpectedConditions.visibilityOf(profilePage.profileName));
        booksPage.clickOnAnyBook();
        String bookToBeAdded = bookPage.titleName();
        bookPage.clickOnAddToCollection();
        driver.navigate().refresh();
        sidebarPage.clickOnButton("Profile");
        Assert.assertEquals(profilePage.booksInProfile.getFirst().getText(), bookToBeAdded);
    }

    @AfterMethod
    public void bookCleanUp() {
        sidebarPage.clickOnButton("Profile");
        profilePage.clickOnDeleteAllBooks();
        profilePage.clickOnOk();
        driver.navigate().refresh();
    }

}
