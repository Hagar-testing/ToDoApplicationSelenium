package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qacart.todo.constants.LocatorsConstant.*;


public class LoginPage extends BasePage {

    @FindBy(id = EMAIL_INPUT)
    private WebElement emailInput;

    @FindBy(id = PASSWORD_INPUT)
    private WebElement passwordInput;

    @FindBy(id = SUBMIT_BUTTON)
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("load login page")
    public LoginPage load() {
        driver.get(ConfigUtils.getBaseUrl());
        return this;
    }

    @Step
    public ToDoPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new ToDoPage(driver);
    }
}
