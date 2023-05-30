package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private WebDriver driver;
    private By password = By.id("ap_password");
    private By SignInBut= By.id("auth-signin-button");
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage clickLogin(){
        driver.findElement(SignInBut).click();
        return new HomePage(driver);
    }

}
