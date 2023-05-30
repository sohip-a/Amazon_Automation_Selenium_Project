package BaseClass;

import Pages.AllVideoGamesPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.eg/-/en/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeClass
    public void Login(){
        LoginPage loginPage= homePage.clickSignIn();
        loginPage.setUserName("sohipas@hotmail.com");
        PasswordPage passwordPage= loginPage.clickContinue();
        passwordPage.setPassword("Amaz0n");
        homePage= passwordPage.clickLogin();
    }


    @AfterTest
    public void closeBrowser(){
      // driver.quit();
    }
}
