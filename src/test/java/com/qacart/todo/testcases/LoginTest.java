package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isWelcomeDisplayed = loginPage
                .load()
                .login("hajer.ibr@gmail.com","Qa_cart23")
                .isWelcomeMsgDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }
}
