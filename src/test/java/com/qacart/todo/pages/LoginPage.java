package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();

    }
}
