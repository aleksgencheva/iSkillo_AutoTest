package iSkillo_tests;

import iSkillo_pages.Header;
import iSkillo_pages.HomePage;
import iSkillo_pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest(){
        System.out.println("1. Navigate to home page.");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Navigate to login.");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3. Check if the correct url is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();

        System.out.println("4. Check if Sign in header is displayed");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText,"Sign in", "Incorrect Sign in header text");

        System.out.println("5. Enter username");
        loginPage.enterUsername("sani");

        System.out.println("6. Enter password");
        loginPage.enterPassword("123456");

        System.out.println("7. Click sign in button");
        loginPage.clickSignIn();

        System.out.println("8. Check if the correct url is opened (homepage)");
        homePage.verifyURLHome();
    }
}
