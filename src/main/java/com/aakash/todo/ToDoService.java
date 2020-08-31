package com.aakash.todo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	private static List<ToDo> ToDos = new ArrayList<ToDo>();
	private static int ToDoCount = 3;

	static {
		ToDos.add(new ToDo(1, "aakash", "Learn Spring MVC", new Date(),
				false));
		ToDos.add(new ToDo(2, "aakash", "Learn Struts", new Date(), false));
		ToDos.add(new ToDo(3, "aakash", "Learn Hibernate", new Date(),
				false));
	}

	public List<ToDo> retrieveToDos(String user) {
		List<ToDo> filteredToDos = new ArrayList<ToDo>();
		for (ToDo ToDo : ToDos) {
			if (ToDo.getUser().equals(user))
				filteredToDos.add(ToDo);
		}
		return filteredToDos;
	}

	public void addToDo(String name, String desc, Date targetDate, boolean isDone) {
		ToDos.add(new ToDo(++ToDoCount, name, desc, targetDate, isDone));
	}

	public void deleteToDo(int id) {
		Iterator<ToDo> iterator = ToDos.iterator();
		while (iterator.hasNext()) {
			ToDo ToDo = iterator.next();
			if (ToDo.getId() == id) {
				iterator.remove();
			}
		}
	}
	public ToDo retrieveTodo(int id) {
		for (ToDo todo : ToDos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(ToDo todo) {
		ToDos.remove(todo);
		ToDos.add(todo);
	}

}
