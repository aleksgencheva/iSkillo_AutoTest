package iSkillo_tests;

import iSkillo_pages.Header;
import iSkillo_pages.LoginPage;
import iSkillo_pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] getUsers() {
        return new Object[][]{
                {"sani", "123456", "sani"}
        };
    }
    @BeforeMethod
    public void initialSetup(){
        LoginPage loginData = new LoginPage(driver);
        loginData.loginCredentials("sani","123456");
    }

    @Test(dataProvider = "users")
    public void profileTest(String username) {

        System.out.println("1. Click Profile Button.");
        Header headerPage = new Header(driver);
        headerPage.goToProfile();

        System.out.println("2. Navigate to profile page.");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfileURL();

        System.out.println("3. Check that the username is displayed correctly");
        String usernameHeaderText = profilePage.getUsernameHeaderText();
        Assert.assertEquals(usernameHeaderText, username, "Incorrect username!");

        System.out.println("4. Validate that the post field is visible");
        ProfilePage postValidation = new ProfilePage(driver);
        postValidation.verifyPostField();

        System.out.println("5. Click on all posts button.");
        ProfilePage allPostsBtn = new ProfilePage(driver);
        allPostsBtn.clickAllBtn();

        System.out.println("6. Navigate and click on the followers button.");
        ProfilePage followersBtn = new ProfilePage(driver);
        followersBtn.clickFollowersBtn();

        System.out.println("7. Validate if the followers pop-up window is shown");
        ProfilePage popUpWindow = new ProfilePage(driver);
        popUpWindow.verifyFollowersPop();

        System.out.println("8. Check if Public posts is marked by default");
        ProfilePage defaultBtn = new ProfilePage(driver);
        defaultBtn.publicPostsBtn();

        System.out.println("9. Verify is following button is visible.");
        ProfilePage verifyFollowingBtn = new ProfilePage(driver);
        verifyFollowingBtn.verifyFollowingField();

        System.out.println("10. Navigate and click on the following button.");
        ProfilePage followingBtn = new ProfilePage(driver);
        followingBtn.clickFollowingBtn();

        System.out.println("11. Validate if the following pop-up window is shown");
        ProfilePage followingWindow = new ProfilePage(driver);
        followingWindow.verifyFollowingPop();
    }
}
