package iSkillo_tests;

import iSkillo_pages.Header;
import iSkillo_pages.HomePage;
import iSkillo_pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerUser() {

        System.out.println("1. Navigate to home page.");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Navigate to login page.");
        Header header = new Header(driver);
        header.goToLogin();

        System.out.println("3. Navigate to register page.");
        RegistrationPage registrationPage = new RegistrationPage(driver);

        System.out.println("4. Click 'register' button.");
        registrationPage.clickRegister();

        System.out.println("5. Enter valid credentials.");
        registrationPage.generateCredentials();

        System.out.println("6. Click 'Submit' button.");
        registrationPage.clickSubmitBtn();
    }

}
