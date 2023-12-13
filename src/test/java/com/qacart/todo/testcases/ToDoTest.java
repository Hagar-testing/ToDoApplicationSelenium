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

        driver.get("http://qacart-todo.herokuapp.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hajer.ibr@gmail.com","Qa_cart23");

        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewToDo();

        String todoText = "to do";
        NewToDoPage newToDoPage = new NewToDoPage(driver);
        newToDoPage.addNewToDo(todoText);

        Assert.assertEquals(todoText, toDoPage.getNewAddedToDoText());
    }

    @Test
    public void shouldBeAbleToDeleteToDo(){

        driver.get("http://qacart-todo.herokuapp.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hajer.ibr@gmail.com","Qa_cart23");

        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewToDo();

        String todoText = "to do";
        NewToDoPage newToDoPage = new NewToDoPage(driver);
        newToDoPage.addNewToDo(todoText);


        toDoPage.deleteToDo();
        Assert.assertTrue(toDoPage.isNoToDosPlaceholderTextIsDisplayed());
    }



}
