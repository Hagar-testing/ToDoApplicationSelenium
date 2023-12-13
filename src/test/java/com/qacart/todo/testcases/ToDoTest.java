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

        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        ToDoPage toDoPage = loginPage.login("hajer.ibr@gmail.com","Qa_cart23");
        String todoText = "to do";
        NewToDoPage newToDoPage = toDoPage.clickOnAddNewToDoButton();
        newToDoPage.addNewToDo(todoText);

        Assert.assertEquals(toDoPage.getNewAddedToDoText(), todoText);
    }

    @Test
    public void shouldBeAbleToDeleteToDo(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        ToDoPage toDoPage = loginPage.login("hajer.ibr@gmail.com","Qa_cart23");

        NewToDoPage newToDoPage = toDoPage.clickOnAddNewToDoButton();
        String todoText = "to do";
        newToDoPage.addNewToDo(todoText);
        toDoPage.clickOnDeleteToDoButton();
        Assert.assertTrue(toDoPage.isNoToDosPlaceholderTextIsDisplayed());
    }



}
