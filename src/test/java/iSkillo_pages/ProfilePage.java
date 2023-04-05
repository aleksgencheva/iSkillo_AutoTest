package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProfilePage extends BasePage {
    public final String BASE_URL = "http://training.skillo-bg.com:4200/users/";

    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameHeader;

    @FindBy(xpath = "//li[contains(text(), ' posts')]")
    WebElement postField;

    @FindBy(id = "followers")
    WebElement followersField;

    @FindBy(id = "following")
    WebElement followingField;

    @FindBy(xpath = "//h4[text()='Followers']")
    WebElement followersPopUp;

    @FindBy(xpath = "//h4[text()='Following']")
    WebElement followingPopUp;

    @FindBy(xpath = "//label[@class='btn-all btn btn-primary']")
    WebElement allPostsBtn;

    @FindBy(xpath = "//label[@class='btn-public btn btn-primary active']")
    WebElement publicPosts;

    @FindBy(css = "app-post")
    List<WebElement> existingPosts;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //Navigate to the username field to check if it is displayed.
    public String getUsernameHeaderText() {
        return getElementText(usernameHeader);
    }

    //Verifying the profile URL
    public void verifyProfileURL() {
        verifyUrlContains(BASE_URL);
    }

    //Checking if the Post Button is visible in the header
    public void verifyPostField() {
        Assert.assertTrue(postField.isDisplayed(), "The profile page should contain the number of posts");
    }

    //Clicking on the Followers Button
    public void clickFollowersBtn() {
        clickElement(followersField);
    }

    //Checking if the Pop Up window appears for the followers
    public void verifyFollowersPop() {
        Assert.assertEquals(followersPopUp.getText(), "Followers", "Incorrect text displayed or pop-op now shown");
    }

    //Checking if the Following Button is visible in the header
    public void verifyFollowingField(){
        Assert.assertTrue(followingField.isDisplayed(),"The following field should contain the number of followers");
    }

    //Using Action Class in order to switch the click from Followers to Following Button
    public void clickFollowingBtn(){
        Actions actions = new Actions(driver);
        actions.moveToElement(followingField).click().build().perform();
        clickElement(followingField);
    }

    //Checking if the Pop Up window appears for the following
    public void verifyFollowingPop(){
        Assert.assertEquals(followingPopUp.getText(), "Following", "Incorrect text displayed or pop-op now shown");
    }

    //Checking if public posts button is set as default button
    public void publicPostsBtn() {
        Assert.assertTrue((publicPosts != null), "Public posts button not marked");
    }

    //Clicking on All posts button
    public void clickAllBtn() {
        clickElement(allPostsBtn);
    }




    public int getExistingPostsCount() {
        return existingPosts.size();
    }

    public void openPostByIndex(int index) {
        clickElement(existingPosts.get(index));
    }
}
