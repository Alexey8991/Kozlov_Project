package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBCSearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchBardata;

    public BBCSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getDataFromSearchBar() {
        return searchBardata.getAttribute("value");
    }
}
