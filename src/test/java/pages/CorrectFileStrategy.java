package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorrectFileStrategy extends BasePage implements Analizator {

    @FindBy(xpath = "//span[@class='file-chooser__files-list-msg']")
    private WebElement textForSuccessfulUploadFile;

    public CorrectFileStrategy(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public String getMessageAfterUploadFile() {
        waitForPageLoadComplete(10);
        return textForSuccessfulUploadFile.getText();
    }
}
