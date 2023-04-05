package iSkillo_tests;

import iSkillo_pages.AvatarPage;
import iSkillo_pages.Header;
import iSkillo_pages.LoginPage;
import iSkillo_pages.ProfilePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class AvatarTest extends BaseTest {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {"sani", "123456", new File("src/test/java/iSkillo_upload/pokemon.jpg")}
        };
    }

    @BeforeMethod
    public void initialSetup() {
        LoginPage loginData = new LoginPage(driver);
        loginData.loginCredentials("sani", "123456");
    }

    @Test(dataProvider = "getData")
    public void changeAvatar(String username, String password, File file) {
        System.out.println("1. Click Profile Button.");
        Header headerPage = new Header(driver);
        headerPage.goToProfile();

        System.out.println("2. Navigate to profile page.");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfileURL();

        System.out.println("3. Go to avatar field and change avatar.");
        AvatarPage avatarPage = new AvatarPage(driver);
        avatarPage.uploadAvatar(file);
    }
}
