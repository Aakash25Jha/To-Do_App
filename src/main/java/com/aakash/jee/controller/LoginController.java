package com.aakash.jee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aakash.jee.UserValidService;

@Controller
public class LoginController {
	UserValidService service = new UserValidService();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Hello() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginUser(@RequestParam String name, @RequestParam String password, ModelMap map) {
		if (!service.isUserValid(name, password)) {
			map.put("err","Wrong Credentails");
			return "login";
		}
		map.put("name", name);
		map.put("password", password);
		return "welcome";
	}
}
