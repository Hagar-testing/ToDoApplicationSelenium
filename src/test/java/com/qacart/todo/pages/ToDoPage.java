package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoPage {

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
        PageFactory.initElements(driver, this);
    }

    public void addNewToDo(){
        addNewToDoButton.click();
    }

    public String getNewAddedToDoText(){
        return toDoTextElement.getText();
    }

    public Boolean isWelcomeMsgDisplayed(){
        return welcomeMsg.isDisplayed();
    }

    public void deleteToDo(){
        deleteToDoButton.click();
    }

    public boolean isNoToDosPlaceholderTextIsDisplayed(){
        return noDoTosPlaceholderText.isDisplayed();
    }

}
