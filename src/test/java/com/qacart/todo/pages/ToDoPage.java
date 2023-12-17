package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qacart.todo.constants.PagePaths.TODO_PAGE_PATH;

public class ToDoPage extends BasePage {

    @FindBy(css = "[data-testid='add']")
    private WebElement addNewToDoButton;

    @FindBy(css = "[data-testid='todo-text']")
    private WebElement toDoTextElement;

    @FindBy(css = "[data-testid='welcome']")
    private WebElement welcomeMsg;


    @FindBy(css = "[data-testid='delete']")
    private WebElement deleteToDoButton;

    @FindBy(css = "[data-testid='no-todos']")
    private WebElement noDoTosPlaceholderText;


    public ToDoPage(WebDriver driver) {
        super(driver);

    }

    public ToDoPage load(){
        driver.get(ConfigUtils.getBaseUrl() + TODO_PAGE_PATH);
        return this;
    }

    public NewToDoPage clickOnAddNewToDoButton(){
        addNewToDoButton.click();
        return new NewToDoPage(driver);
    }

    public String getNewAddedToDoText(){
        return toDoTextElement.getText();
    }

    public Boolean isWelcomeMsgDisplayed(){
        return welcomeMsg.isDisplayed();
    }

    public ToDoPage clickOnDeleteToDoButton(){
        deleteToDoButton.click();
        return this;
    }

    public boolean isNoToDosPlaceholderTextIsDisplayed(){
        return noDoTosPlaceholderText.isDisplayed();
    }

}
