package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Analizator;
import pages.BBCHomePage;
import pages.BasePage;

public class TestBbcTask1 extends BaseTest {

    @DataProvider
    public Object[][] typeOfSport() {
        return new Object[][]{
                {"Football"},
                {"Tennis"},
                {"Golf"}
        };
    }

    @Test(dataProvider = "typeOfSport")
    public void checkThatHeadlineArticleWorksCorrectly(String typeOfSport) {
        String EXPECTED_PAGE_URL = "";
        switch (typeOfSport) {
            case "Football" -> EXPECTED_PAGE_URL = "https://www.bbc.com/sport/football";
            case "Tennis" -> EXPECTED_PAGE_URL = "https://www.bbc.com/sport/tennis";
            case "Golf" -> EXPECTED_PAGE_URL = "https://www.bbc.com/sport/golf";
            default -> {
                System.out.println("Incorrect test data, try again");
            }
        }

        String actualPageUrl = new BBCHomePage(driver)
                .clickSportNewsButton()
                .clickSpecificSportNewsButton(typeOfSport)
                .getCurrentUrl();

        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, "Actual and expected page url are different");
    }

    @Test(dataProvider = "typeOfSport")
    public void checkNullPointerException(String typeOfSport) {
        String EXPECTED_VALUE;

        switch (typeOfSport) {
            case "Football" -> EXPECTED_VALUE = "Football";
            case "Tennis" -> EXPECTED_VALUE = "Tennis";
            default -> {
                EXPECTED_VALUE = null;
            }
        }

        String actualValue = new BBCHomePage(driver)
                .getSearchByParameters(typeOfSport)
                .getDataFromSearchBar();

        Assert.assertEquals(actualValue.length(), EXPECTED_VALUE.length(), "Actual and expected length are different");
    }
}
