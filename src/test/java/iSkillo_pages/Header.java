package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {

    @FindBy(id = "nav-link-home")
    WebElement homeLink;

    @FindBy(css = "#nav-link-login")
    WebElement loginLink;

    @FindBy(linkText = "Profile")
    WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Clicking on login link.
    public void goToLogin() {
        clickElement(loginLink);
    }

    //Navigating to profile link.
    public void goToProfile() {
        clickElement(profileLink);
    }

    //Navigating to new post link.
    public void goToNewPost() {
        clickElement(newPostLink);
    }
}
