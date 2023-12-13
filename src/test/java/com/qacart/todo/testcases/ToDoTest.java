package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo(){
        String todoText = "to do";
        LoginPage loginPage = new LoginPage(driver);
        String newAddedToDoText = loginPage
                .load()
                .login("hajer.ibr@gmail.com","Qa_cart23")
                .clickOnAddNewToDoButton()
                .addNewToDo(todoText)
                .getNewAddedToDoText();
        Assert.assertEquals(newAddedToDoText, todoText);
    }

    @Test
    public void shouldBeAbleToDeleteToDo(){
        String todoText = "to do";
        LoginPage loginPage = new LoginPage(driver);
        Boolean isNoToDosPlaceholderTextIsDisplayed = loginPage
                .load()
                .login("hajer.ibr@gmail.com","Qa_cart23")
                .clickOnAddNewToDoButton()
                .addNewToDo(todoText)
                .clickOnDeleteToDoButton()
                .isNoToDosPlaceholderTextIsDisplayed();
        Assert.assertTrue(isNoToDosPlaceholderTextIsDisplayed);
    }



}
