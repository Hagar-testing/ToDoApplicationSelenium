package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qacart.todo.constants.PagePaths.NEW_TODO_PAGE_PATH;
import static com.qacart.todo.constants.PagePaths.TODO_PAGE_PATH;

public class NewToDoPage extends BasePage {


    @FindBy(css = "[data-testid='new-todo']")
    private WebElement newToDoInput;

    @FindBy(css = "[data-testid='submit-newTask']")
    private WebElement submitNewTaskButton;


    public NewToDoPage(WebDriver driver) {
        super(driver);
    }

    public NewToDoPage load(){
        driver.get(ConfigUtils.getBaseUrl() + NEW_TODO_PAGE_PATH);
        return this;
    }


    public ToDoPage addNewToDo(String todoText){
        newToDoInput.sendKeys(todoText);
        submitNewTaskButton.click();
        return new ToDoPage(driver);
    }
}
