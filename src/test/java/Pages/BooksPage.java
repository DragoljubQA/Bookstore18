package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class BooksPage extends BaseTest {

    public BooksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "mr-2")
    public List<WebElement> books;

    //-------------------------

    public void clickOnCertainBook(String bookName) {
        driver.findElement(By.id("see-book-"+bookName)).click();
    }

    public void clickOnAnyBook(){
        Random random = new Random();
        int randomNumber = random.nextInt(books.size());
        scrollToElement(books.get(randomNumber));
        books.get(randomNumber).click();
    }


}
