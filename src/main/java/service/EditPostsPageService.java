package service;

import page.EditPostsPage;

import java.util.Random;

public class EditPostsPageService {

    private EditPostsPage editPostsPage = new EditPostsPage();

    public EditPostsPage saveChangedRating(String newRating) {
        editPostsPage.setupRating(newRating)
                .clickOnUpdateButton();
        return editPostsPage;
    }

    public EditPostsPage saveChangedPost(String newPost) {
        editPostsPage.setupPost(newPost)
                .clickOnUpdateButton();
        return editPostsPage;
    }

    public EditPostsPage addPost(String postText, String rating){
        return editPostsPage
                .setupPost(postText)
                .setupRating(rating)
                .clickOnAddButton();
    }

    public EditPostsPage deletePost(){
        return editPostsPage.clickOnDeleteButton();
    }

    public boolean isUpdatedSuccessMessageAppears() {
        return editPostsPage.isUpdatedSuccessMessagePopUpAppears();
    }

    public boolean isAddedSuccessMessageAppears() {
        return editPostsPage.isAddedSuccessMessagePopUpAppears();
    }

    public boolean isErrorMessageAppears() {
        return editPostsPage.isErrorMessagePopUpAppears();
    }

    public boolean isDeletedMessageAppears() {
        return editPostsPage.isDeletedMessagePopUpAppears();
    }

    public String generatePostText() {
        return "New Post Text " + new Random().nextInt(30);
    }

}
