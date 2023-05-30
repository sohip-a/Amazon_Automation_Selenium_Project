package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.id("ap_email");
    private By continueBut= By.id("continue");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String user) {
        driver.findElement(userName).sendKeys(user);
    }


    public PasswordPage clickContinue(){
        driver.findElement(continueBut).click();
        return new PasswordPage(driver);
    }


}
