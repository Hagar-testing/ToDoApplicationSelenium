package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qacart.todo.constants.LocatorsConstant.NEW_TODO_INPUT;
import static com.qacart.todo.constants.LocatorsConstant.SUBMIT_NEW_TASK_BUTTON;
import static com.qacart.todo.constants.PagePathsConstant.NEW_TODO_PAGE_PATH;

public class NewToDoPage extends BasePage {


    @FindBy(css = NEW_TODO_INPUT)
    private WebElement newToDoInput;

    @FindBy(css = SUBMIT_NEW_TASK_BUTTON)
    private WebElement submitNewTaskButton;


    public NewToDoPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public NewToDoPage load() {
        driver.get(ConfigUtils.getBaseUrl() + NEW_TODO_PAGE_PATH);
        return this;
    }

    @Step
    public ToDoPage addNewToDo(String todoText) {
        newToDoInput.sendKeys(todoText);
        submitNewTaskButton.click();
        return new ToDoPage(driver);
    }
}
