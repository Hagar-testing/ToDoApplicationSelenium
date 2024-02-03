package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.qacart.todo.constants.LocatorsConstant.*;
import static com.qacart.todo.constants.PagePathsConstant.TODO_PAGE_PATH;

public class ToDoPage extends BasePage {

    @FindBy(css = ADD_NEW_TODO_BUTTON)
    private WebElement addNewToDoButton;

    @FindBy(css = TODO_TEXT_ELEMENT)
    private WebElement toDoTextElement;

    @FindBy(css = WELCOME_MSG)
    private WebElement welcomeMsg;

    @FindBy(css = DELETE_TODO_BUTTON)
    private WebElement deleteToDoButton;

    @FindBy(css = NO_TODOS_PLACEHOLDER_TEXT)
    private WebElement noDoTosPlaceholderText;


    public ToDoPage(WebDriver driver) {
        super(driver);

    }

    @Step
    public ToDoPage load() {
        driver.get(ConfigUtils.getBaseUrl() + TODO_PAGE_PATH);
        return this;
    }

    @Step
    public NewToDoPage clickOnAddNewToDoButton() {
        addNewToDoButton.click();
        return new NewToDoPage(driver);
    }

    @Step
    public String getNewAddedToDoText() {
        return toDoTextElement.getText();
    }

    @Step
    public Boolean isWelcomeMsgDisplayed() {
        return welcomeMsg.isDisplayed();
    }

    @Step
    public ToDoPage clickOnDeleteToDoButton() {
        deleteToDoButton.click();
        return this;
    }

    @Step
    public boolean isNoToDosPlaceholderTextIsDisplayed() {
        return noDoTosPlaceholderText.isDisplayed();
    }

}
