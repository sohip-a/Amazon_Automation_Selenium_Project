package LoginTest;

import BaseClass.BaseTest;
import Pages.LoginPage;
import Pages.PasswordPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testopen(){
        LoginPage loginPage= homePage.clickSignIn();
        loginPage.setUserName("sohipas@hotmail.com");
        PasswordPage passwordPage= loginPage.clickContinue();
        passwordPage.setPassword("Amaz0n");
        homePage= passwordPage.clickLogin();
    }
}
