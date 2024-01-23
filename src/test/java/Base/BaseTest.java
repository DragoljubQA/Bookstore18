package Base;

import Pages.LoginPage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;
    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("TestData.xlsx");
        //Da se file nalazi u paketu Tests
        //excelReader = new ExcelReader("src\\test\\java\\Tests\\TestData.xlsx");
    }



}
