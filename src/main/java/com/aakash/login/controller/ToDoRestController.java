package com.aakash.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.todo.ToDo;
import com.aakash.todo.ToDoService;

@RestController
public class ToDoRestController {
@Autowired
ToDoService service;

	@RequestMapping(path="/todos")
	public List<ToDo> retrieveAllToDos(){
		return service.retrieveToDos("aakash");
	}
}
