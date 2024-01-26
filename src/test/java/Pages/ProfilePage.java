package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName-value")
    public WebElement profileName;

    @FindBy(className = "mr-2")
    public List<WebElement> booksInProfile;

    @FindBy(id = "submit")
    public List<WebElement> profileButtons;

    @FindBy(id = "closeSmallModal-ok")
    public WebElement okButton;

    //--------------------

    public String profileNameText() {
        return profileName.getText();
    }

    public void clickOnDeleteAllBooks() {
        for (int i = 0; i < profileButtons.size(); i++) {
            if (profileButtons.get(i).getText().equals("Delete All Books")) {
                profileButtons.get(i).click();
                break;
            }
        }
    }

    public void clickOnOk() {
        okButton.click();
    }

}
