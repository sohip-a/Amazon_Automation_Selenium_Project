package AllVedioGamesTasts;

import BaseClass.BaseTest;
import Pages.AllVideoGamesPage;
import org.testng.annotations.Test;

public class AllVideoGamesTests extends BaseTest {
    @Test
    public void AllGames(){
        AllVideoGamesPage allVideoGamesPage= homePage.clickVideogames();
        allVideoGamesPage.chooseFreeShipping();
        allVideoGamesPage.chooseFreeShipping();
        allVideoGamesPage.chooseNewCondition();
        allVideoGamesPage.sortByByVisibleText();
        allVideoGamesPage.addproductsBelowCost();
    }
}
