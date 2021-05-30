package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BBCHomePage;

public class TestBbcTask2 extends BaseTest {

    @DataProvider
    public Object[][] typesOfUploadedFile() {
        return new Object[][]{
                {"src/test/java/resources/incorrectTypeOfFile.txt"},
                {"src/test/java/resources/correctTypeOfFile.png"}
        };
    }

    @Test(dataProvider = "typesOfUploadedFile")
    public void checkMessageForUploadedFile(String typesOfUploadedFile) {
        String EXPECTED_MESSAGE = "";

        if (typesOfUploadedFile.contains("txt")) {
            EXPECTED_MESSAGE = "Sorry, we can't use this type of file. Please add JPEG, PNG, GIF, AVI, QUICKTIME, X-MS-WMV, MP4, MPEG, X-FLV, 3GPP, X-M4V, X-MS-WMA, X-WAV, MPEG, MP3, WAV, WMA, MP4, X-M4A.";
        }
        else {
            EXPECTED_MESSAGE = "Here's what you're uploading:";
        }
        String actualMessageForPicture = new BBCHomePage(driver)
                .getNewsPage()
                .clickCoronavirusNewsButton()
                .clickCoronavirusStoriesButton()
                .getSharePhotosWithBbc()
                .uploadYourFile(typesOfUploadedFile)
                .getMessageAfterUploadFile();

        Assert.assertEquals(actualMessageForPicture,EXPECTED_MESSAGE, "Actual and expected message for uploaded file are different");
    }
}
