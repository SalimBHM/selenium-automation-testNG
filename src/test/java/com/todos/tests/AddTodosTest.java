package com.todos.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodosPage;
import com.todos.utils.Setup;

public class AddTodosTest extends Setup{
	
	public AddTodosTest() throws IOException {
		super();
	}
	
	TodosPage todosPage;
	@Test(priority = 1)
	public void iCanAddTodo() throws IOException {
		todosPage = new TodosPage();
		boolean elementText = todosPage.isElementDisplayed(TodosPage.inputField);
		Assert.assertTrue(elementText);
		todosPage.submitTodo(prop.getProperty("todo1"));
		String elementTodo = todosPage.checkElementContains(TodosPage.element1);
		Assert.assertTrue(elementTodo.contains(prop.getProperty("todo1")));
		boolean checkbox = todosPage.isCheckboxSelected(TodosPage.checkbox);
		Assert.assertFalse(checkbox);
	}

}
