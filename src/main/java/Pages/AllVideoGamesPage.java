package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllVideoGamesPage {
    private WebDriver driver;
    private By freeshippingCB = By.xpath("//i[@class=\"a-icon a-icon-checkbox\"]");
    private final By newCondion = By.xpath("//*[@id=\"p_n_condition-type/28071525031\"]/span/a/span");
private By sortBy=By.id("a-autoid-0-announce");
private By highToLow=By.id("s-result-sort-select_2");
    public AllVideoGamesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFreeShipping() {
        driver.findElement(freeshippingCB).click();
    }

    public void chooseNewCondition() {
        driver.findElement(newCondion).click();
    }

    public void sortByByVisibleText() {
        driver.findElement(sortBy).click();
        driver.findElement(highToLow).click();
    }
    //to convert the web element to string to be compared
    public List<String> convertPrices(List<WebElement> pricesWE) {
        List<String> prices=new ArrayList<>();
        for (WebElement element : pricesWE) {
            prices.add(element.getText());
        }
        return prices;
    }
    public void addproductsBelowCost() {
       List<WebElement> pricesWE =  new ArrayList<>();
        pricesWE=driver.findElements(By.xpath("//div[@class=\"a-section\"]//child::div[@class=\"a-row a-size-base a-color-base\"]"));
        System.out.println(pricesWE);
        List<String> pricesSTR= new ArrayList<>();
        pricesSTR =convertPrices(pricesWE);
        System.out.println(pricesSTR);
    }
}
