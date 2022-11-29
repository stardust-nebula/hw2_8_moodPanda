package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.EditPostsPageService;
import service.LoginPageService;

public class EditPostsTest extends BaseTest {

    private static User user;
    private static EditPostsPageService editPostsPageService;

    @BeforeClass
    public void openEditPostPage() {
        user = new User();
        editPostsPageService = new EditPostsPageService();
        new LoginPageService()
                .login(user)
                .clickEditPostsLink();
    }

    @Test(priority = 2, description = "Verify successful changing rating of the post")
    public void checkSuccessfulChangingRatingTest() {
        String newRating = "1";
        editPostsPageService.saveChangedRating(newRating);
        Assert.assertTrue(editPostsPageService.isUpdatedSuccessMessageAppears());
    }

    @Test(priority = 3, description = "Verify successful changing text of the post")
    public void checkSuccessfulChangingPostTextTest() {
        String newPostText = editPostsPageService.generatePostText();
        editPostsPageService.saveChangedPost(newPostText);
        Assert.assertTrue(editPostsPageService.isUpdatedSuccessMessageAppears());
    }

    @Test(priority = 1, description = "Verify successful adding a new post")
    public void checkSuccessfulAddingNewPostTest() {
        String newPostText = "Created Post";
        String newRating = "1";
        editPostsPageService.addPost(newPostText, newRating);
        Assert.assertTrue(editPostsPageService.isAddedSuccessMessageAppears());
    }

    @Test(priority = 4, description = "Verify successful showing error message if add post with less that allowed text length")
    public void checkErrorMessageWhenSavingPostLengthLessAllowedTest() {
        String newPostText = "One";
        String newRating = "6";
        editPostsPageService.addPost(newPostText, newRating);
        editPostsPageService.saveChangedPost(newPostText);
        Assert.assertTrue(editPostsPageService.isErrorMessageAppears());
    }

    @Test(priority = 5, description = "Verify successful deleting post")
    public void checkSuccessfulRemovingPostTest() {
        String newPostText = "Post to be deleted";
        String newRating = "3";
        editPostsPageService.addPost(newPostText, newRating);
        editPostsPageService.deletePost();
        Assert.assertTrue(editPostsPageService.isDeletedMessageAppears());
    }

}
