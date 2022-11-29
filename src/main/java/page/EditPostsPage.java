package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditPostsPage {

    private static List<SelenideElement> RATING_DROP_DOWN = $$(By.xpath("//td//select[1]"));
    private static List<SelenideElement> POST_FIELD = $$(By.xpath("//td[@class='wrap']/textarea"));
    private static List<SelenideElement> UPDATE_BUTTON = $$(By.xpath("//table//button[contains(text(),'Update')]"));
    private static List<SelenideElement> ADD_BUTTON = $$(By.xpath("//table//button[contains(text(),'Add')]"));
    private static List<SelenideElement> DELETE_BUTTON = $$(By.xpath("//table//button[contains(text(),'Delete')]"));
    private static SelenideElement UPDATE_POP_UP_MESSAGE = $(By.xpath("//*[contains(text(), 'Post updated')]"));
    private static SelenideElement ADDED_POP_UP_MESSAGE = $(By.xpath("//*[contains(text(), 'Posted')]"));
    private static SelenideElement ERROR_POP_UP_MESSAGE = $(By.xpath("//*[contains(text(), 'Post failed:The Reason must be at least 5 letters long.')]"));
    private static SelenideElement DELETED_POP_UP_MESSAGE = $(By.xpath("//*[contains(text(), 'Post deleted')]"));

    private static final int POSITION = 0;

    public EditPostsPage setupRating(String rating) {
        RATING_DROP_DOWN.get(POSITION).selectOption(rating);
        return this;
    }

    public EditPostsPage setupPost(String post) {
        POST_FIELD.get(POSITION).clear();
        POST_FIELD.get(POSITION).sendKeys(post);
        return this;
    }

    public EditPostsPage clickOnUpdateButton() {
        UPDATE_BUTTON.get(POSITION).click();
        return this;
    }

    public EditPostsPage clickOnAddButton() {
        ADD_BUTTON.get(POSITION).click();
        return this;
    }

    public EditPostsPage clickOnDeleteButton() {
        DELETE_BUTTON.get(POSITION).click();
        return this;
    }

    public boolean isUpdatedSuccessMessagePopUpAppears() {
        return UPDATE_POP_UP_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public String getTextFromPostField() {
        return POST_FIELD.get(POSITION).getAttribute("Value");
    }

    public boolean isAddedSuccessMessagePopUpAppears() {
        return ADDED_POP_UP_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isErrorMessagePopUpAppears() {
        return ERROR_POP_UP_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isDeletedMessagePopUpAppears() {
        return DELETED_POP_UP_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

}
