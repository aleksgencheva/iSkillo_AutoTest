package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class RegistrationPage extends BasePage{

    final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/users/register']")
    WebElement registerLink;

    @FindBy(xpath = "//h4[@class='text-center mb-4']")
    WebElement signInText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    WebElement confirmPassField;

    @FindBy(css="button[type=submit]")
    WebElement submitBtn;

    //Clicks on register button.
    public void clickRegister(){
        clickElement(registerLink);
    }
    //Generates random register credentials.
    public void generateCredentials(){

        for(int i = 0; i < 7; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);

        }
        String username = sb.toString();
        String password = sb.toString();
        String email = sb.toString() + "@abv.bg";

        enterText(usernameField, username);
        enterText(emailField, email);
        enterText(passwordField, password);
        enterText(confirmPassField, password);
    }
    //Clicks on submit button.
    public void clickSubmitBtn(){
        clickElement(submitBtn);
    }
}
