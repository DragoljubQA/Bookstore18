package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "name")
    public WebElement error;

    //--------------------

    public void inputUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void inputPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String errorMessage() {
        return error.getText();
    }

}
