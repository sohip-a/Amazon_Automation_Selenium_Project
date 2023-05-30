package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickElement(String textLink) {
        driver.findElement(By.id(textLink)).click();
    }

    public LoginPage clickSignIn() {
        clickElement("nav-link-accountList");
        return new LoginPage(driver);
    }

    public void clickAllButton() {
        clickElement("nav-hamburger-menu");
    }

    public AllVideoGamesPage clickVideogames() {
        //click all button int the home pasge
        driver.findElement(By.id("nav-hamburger-menu")).click();
        //expand the chosies list by clicking see all
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@class=\"hmenu-item hmenu-compressed-btn\"]")).click();
        // SELECT Video games
        driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > ul > li:nth-child(11) > a")).click();
        //go to all video games page
        driver.findElement(By.linkText("All Video Games")).click();
        return  new AllVideoGamesPage(driver);
    }

}
