package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBCHomePage extends BasePage implements Pages {

    @FindBy(xpath = "//a[@href='https://www.bbc.com/sport']")
    private WebElement sportNews;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchBar;

    public BBCHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public BBCSportPage clickSportNewsButton() {
        sportNews.click();
        return new BBCSportPage(driver);
    }

    public BBCSearchPage getSearchByParameters(String searchWord) {
        searchBar.sendKeys(searchWord);
        searchBar.sendKeys(Keys.ENTER);
        return new BBCSearchPage(driver);
    }
}
