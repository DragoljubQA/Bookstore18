package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "text")
    public List<WebElement> sidebarButton;

    //-----------------------

    public void clickOnButton(String buttonName) {
        for (int i = 0; i < sidebarButton.size(); i++) {
            if (sidebarButton.get(i).getText().equals(buttonName)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", sidebarButton.get(i));
                sidebarButton.get(i).click();
                break;
            }
        }
    }

}
