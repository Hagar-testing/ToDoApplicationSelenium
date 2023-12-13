package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewToDoPage {


    @FindBy(css = "[data-testid='new-todo']")
    private WebElement newToDoInput;

    @FindBy(css = "[data-testid='submit-newTask']")
    private WebElement submitNewTaskButton;


    public NewToDoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void addNewToDo(String todoText){
        newToDoInput.sendKeys(todoText);
        submitNewTaskButton.click();
    }
}
