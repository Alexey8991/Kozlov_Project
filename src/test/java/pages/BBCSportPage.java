package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBCSportPage extends BasePage implements Pages {

    @FindBy(xpath = "//div[@class='gel-wrap sp-c-sport-navigation__wrapper']//a[@data-stat-link='/sport/football']")
    private WebElement footballNews;

    @FindBy(xpath = "//div[@class='gel-wrap sp-c-sport-navigation__wrapper']//a[@data-stat-link='/sport/tennis']")
    private WebElement tennisNews;

    @FindBy(xpath = "//div[@class='gel-wrap sp-c-sport-navigation__wrapper']//a[@data-stat-link='/sport/golf']")
    private WebElement golfNews;

    public BBCSportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public BBCSportPage clickSpecificSportNewsButton (String TypeOfSport) {
        switch (TypeOfSport) {
            case "Football" -> footballNews.click();
            case "Tennis" -> tennisNews.click();
            case "Golf" -> golfNews.click();
            default -> {
                System.out.println("Type of sport not found, try again with other test data");
            }
        }
        return this;
    }
}