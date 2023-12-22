package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Classic Login")
    @Description("It will be login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed = loginPage
                .load()
                .login(ConfigUtils.getEmail(),ConfigUtils.getPassword())
                .isWelcomeMsgDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }
}
