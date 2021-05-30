package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class BBCNewsPage extends BasePage {

    @FindBy(xpath = "//div[@class='gs-u-display-none gs-u-display-block@m nw-o-news-wide-navigation']//a[@href='/news/coronavirus']")
    private WebElement coronavirusNews;

    @FindBy(xpath = "//div[@class='gs-u-display-none gs-u-display-block@m']//a[@href='/news/have_your_say']")
    private WebElement coronavirusStories;

    @FindBy(xpath = "//a[@href='https://www.bbc.co.uk/send/u16904890?ptrt=https://www.bbc.co.uk/news/world-10776546']")
    private WebElement sharePhotosWithBbc;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement chooseUploadedFile;

    @FindBy(xpath = "//span[@class='file-chooser__files-list-msg']")
    private WebElement textForSuccessfulUploadFile;

    @FindBy(xpath = "//div[@class='ugc-form__error-message ugc-form__error-message--pointer-left']")
    private WebElement textForUnsuccessfulUploadFile;

    //String filePath = "src/test/java/resources/incorrectTypeOfFile.txt";

    public BBCNewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public BBCNewsPage clickCoronavirusNewsButton() {
        coronavirusNews.click();
        return this;
    }

    public BBCNewsPage clickCoronavirusStoriesButton() {
        coronavirusStories.click();
        return this;
    }
    public BBCNewsPage getSharePhotosWithBbc() {
        sharePhotosWithBbc.click();
        return this;
    }

    public Analizator uploadYourFile(String filePath) {
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        chooseUploadedFile.sendKeys(absolutePath);
        waitForPageLoadComplete(10);
        if(absolutePath.contains("txt")){
            return new IncorrectFileStrategy(driver);
        }
        else {
            return new CorrectFileStrategy(driver);
        }
    }
}
