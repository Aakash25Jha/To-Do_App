 package com.aakash.login.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aakash.todo.ToDo;
import com.aakash.todo.ToDoService;

@Controller
@SessionAttributes("name")
public class ToDoController {

@Autowired
ToDoService service;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat date= new SimpleDateFormat("dd/MM/yyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(date, false));
	}
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showToDos(ModelMap model) {
		model.addAttribute("todos",service.retrieveToDos(retrieveUser()));
		return "list-todo";
	}
	private String retrieveUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addToDo(ModelMap model){
		model.addAttribute("todo", new ToDo());
		return "todo";
	}
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addToDoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		service.addToDo(retrieveUser(), todo.getDesc() , new Date(), false);
		model.clear();
		return "redirect: list-todos";
	}
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String addToDoPost(ModelMap model,@RequestParam int id){
		service.deleteToDo(id);
		model.clear();
		return "redirect: list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateToDoPost(ModelMap model, @RequestParam int id) {
		ToDo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateToDoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(retrieveUser());
		service.updateTodo(todo);
		return "redirect:list-todos";
		}
	}
