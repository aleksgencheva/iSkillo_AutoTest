package iSkillo_tests;

import iSkillo_pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostsTest extends BaseTest {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{
                {"sani", "123456", new File("src/test/java/iSkillo_upload/Japan-2107x1406.jpg"), "caption"}
        };
    }

    @BeforeMethod
    public void initialSetup() {
        LoginPage loginData = new LoginPage(driver);
        loginData.loginCredentials("sani", "123456");
    }

    @Test(dataProvider = "getData")
    public void postsTest(String username, String password, File file, String captionText) {
        System.out.println("1. Click Profile Button.");
        Header headerPage = new Header(driver);
        headerPage.goToProfile();

        System.out.println("2. Navigate to profile page.");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyProfileURL();
        int initialExistingPosts = profilePage.getExistingPostsCount();

        System.out.println("3. Go to new post");
        headerPage.goToNewPost();
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.verifyUrl();

        System.out.println("4. Upload a new picture");
        newPostPage.uploadImage(file);

        System.out.println("5. Verify that the image is visible");
        newPostPage.waitForImageToShow();

        System.out.println("6. Verify the image name is correct");
        Assert.assertEquals(newPostPage.getImageFilename(), file.getName(), "Image did not show up");

        System.out.println("7. Populate the post caption");
        newPostPage.populateCaption(captionText);

        System.out.println("8. Click create post");
        newPostPage.submitPost();
        profilePage.verifyProfileURL();

        System.out.println("9. Verify the post number has increased");
        int existingPosts = profilePage.getExistingPostsCount();
        Assert.assertEquals(existingPosts, initialExistingPosts + 1, "Incorrect posts count!");

        System.out.println("10. Open the latest post");
        profilePage.openPostByIndex(existingPosts - 1);
        PostsPage postsPage = new PostsPage(driver);
        postsPage.waitForDialogToAppear();

        System.out.println("11. Verify the post details");
        Assert.assertEquals(postsPage.getPostUsername(), username, "Username is not correct in the post!");
    }
}
