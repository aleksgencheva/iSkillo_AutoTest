package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;

public class AvatarPage extends BasePage {
    public AvatarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input#upload-img")
    WebElement avatarPic;
    //Navigate to the image path
    public void uploadAvatar(File file) {
        avatarPic.sendKeys(file.getAbsolutePath());
    }
}



