package AllVedioGamesTasts;

import BaseClass.BaseTest;
import Pages.AllVideoGamesPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllVideoGamesTests extends BaseTest {
    private WebDriver driver;
    @Test
    public void AllGames(){
       AllVideoGamesPage allVideoGamesPage= homePage.clickVideogames();

        allVideoGamesPage.chooseFreeShipping();
      // allVideoGamesPage.chooseNewCondition();
        allVideoGamesPage.sortByByVisibleText();
        //ADD PRODUCTS TO CART AND SPECIFY THE AMOUNT TO CHECK PRICES BELOW
        allVideoGamesPage.addToCart(15000);
        //ASSERT THAT THE NUMBER OF ITEMES IN THE CART IS EQUAL TO THE NUMBER OF PRUDECTS THAT HAVE LOWER PRICES THAN THE BASE
        Assert.assertEquals(Integer.parseInt(allVideoGamesPage.getNumberInCart()),allVideoGamesPage.getIntPrices().size());
    }
}
