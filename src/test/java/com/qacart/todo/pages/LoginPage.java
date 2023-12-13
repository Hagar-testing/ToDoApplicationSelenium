package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load(){
         driver.get("http://qacart-todo.herokuapp.com/");
         return this;
    }
    public ToDoPage login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new ToDoPage(driver);
    }
}
