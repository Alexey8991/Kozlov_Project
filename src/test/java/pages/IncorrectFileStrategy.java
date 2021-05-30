package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectFileStrategy extends BasePage implements Analizator {

    @FindBy(xpath = "//div[@class='ugc-form__error-message ugc-form__error-message--pointer-left']")
    private WebElement textForUnsuccessfulUploadFile;

    public IncorrectFileStrategy(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public String getMessageAfterUploadFile() {
        waitForPageLoadComplete(10);
        return textForUnsuccessfulUploadFile.getText();
    }
}
