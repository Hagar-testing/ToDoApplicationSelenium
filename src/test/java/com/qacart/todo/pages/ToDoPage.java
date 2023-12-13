package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickOnAddNewToDoButton(){
        addNewToDoButton.click();
    }

    public String getNewAddedToDoText(){
        return toDoTextElement.getText();
    }

    public Boolean isWelcomeMsgDisplayed(){
        return welcomeMsg.isDisplayed();
    }

    public void clickOnDeleteToDoButton(){
        deleteToDoButton.click();
    }

    public boolean isNoToDosPlaceholderTextIsDisplayed(){
        return noDoTosPlaceholderText.isDisplayed();
    }

}
