package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public final String URL = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(css = "form .h4")
    WebElement signInHeader;

    @FindBy(name = "usernameOrEmail")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    public void loginCredentials(String username, String password){

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("1. Navigate to login.");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("2. Check if the correct url is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();

        System.out.println("3. Check if Sign in header is displayed");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText,"Sign in", "Incorrect Sign in header text");

        System.out.println("4. Enter username");
        loginPage.enterUsername("sani");

        System.out.println("5. Enter password");
        loginPage.enterPassword("123456");

        System.out.println("6. Click sign in button");
        loginPage.clickSignIn();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Enter username.
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    //Enter password.
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    //Sign in button to be clickable.
    public void clickSignIn() {
        clickElement(signInBtn);
    }

    //Validate that the sign in header is present.
    public String getSignInHeaderText() {
        return getElementText(signInHeader);
    }

    //Verify url.
    public void verifyUrl() {
        verifyUrl(URL);
    }

}
