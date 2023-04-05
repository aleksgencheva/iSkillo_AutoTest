package iSkillo_tests;

import iSkillo_pages.Header;
import iSkillo_pages.LoginPage;
import iSkillo_pages.ModifyProfilePage;
import iSkillo_pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ModifyProfileTest extends BaseTest {

    @DataProvider(name = "getCredentials")
    public Object[][] getUsers() {
        return new Object[][]{
                {"sani", "123456", "Hello guys!"}
        };
    }

    @BeforeMethod
    public void initialSetup() {
        LoginPage loginData = new LoginPage(driver);
        loginData.loginCredentials("sani", "123456");
    }

    @Test(dataProvider = "getCredentials")
    public void modifyProfile(String username, String password, String publicText) {

        System.out.println("1. Click Profile Button.");
        Header headerPage = new Header(driver);
        headerPage.goToProfile();

        System.out.println("2. Navigate to profile page.");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfileURL();

        System.out.println("3. Click modify profile button and check if pop-up window is shown.");
        ModifyProfilePage modifyProfilePage = new ModifyProfilePage(driver);
        modifyProfilePage.clickModifyBtn();
        modifyProfilePage.modifyWindow();

        System.out.println("4. Click in the filed for public info and Insert text");
        modifyProfilePage.deleteInfo();
        modifyProfilePage.insertText();
        modifyProfilePage.clickSave();
    }
}
