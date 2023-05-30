package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AllVideoGamesPage {
    private WebDriver driver;
    private By freeshippingCB = By.xpath("//i[@class=\"a-icon a-icon-checkbox\"]");
    //private final By newCondion = By.xpath("//*[@id=\"p_n_condition-type/28071525031\"]/span/a/span");
    private final By newCondion = By.xpath("//*[@id=\"s-refinements\"]/div[6]/ul/li[1]/span");
    private By sortBy = By.id("a-autoid-0-announce");
    private By highToLow = By.id("s-result-sort-select_2");
    private List<Integer> intPrices;
    private List<String> strPrices;

    public List<Integer> getIntPrices() {
        return intPrices;
    }

    public void setIntPrices(List<Integer> intPrices) {
        this.intPrices = intPrices;
    }

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
        List<String> prices = new ArrayList<>();
        for (WebElement element : pricesWE) {
            prices.add(element.getText());
        }
        return prices;
    }

    public void getProductsPrices() {
        List<WebElement> pricesWE = new ArrayList<>();
        pricesWE = driver.findElements(By.xpath("//div[@class=\"a-section\"]//child::span[@class=\"a-price-whole\" and translate(normalize-space(), ',', '') ]"));
        strPrices = new ArrayList<>();
        strPrices = convertPrices(pricesWE);

    }

    // filter the total list to get a new one with the desired range
    public void setWantedPrices(int priceBase) {
        int tempPrice = 0;
        intPrices = new ArrayList<>();
        for (String price : strPrices) {
            price = price.replace(",", "");
            tempPrice = Integer.parseInt(price);
            if (tempPrice <= priceBase) {
                intPrices.add(tempPrice);
            }
        }
    }

    public void addToCart(int basePrice) {
        getProductsPrices();
        setWantedPrices(basePrice);

        for (Integer targetPrice : intPrices) {
            driver.findElement(By.xpath
                    ("//div[@class=\"a-section\"]//child::span[@class=\"a-price-whole\" and translate(normalize-space(), ',', '') =" + targetPrice + "] /ancestor::a")).click();
            clickAddToCart();
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.navigate().back();
        }
        driver.navigate().refresh();
    }

    public void clickAddToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }
    public String getNumberInCart(){
        return driver.findElement(By.id("nav-cart-count")).getText();
    }
}
