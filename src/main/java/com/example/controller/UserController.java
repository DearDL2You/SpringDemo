package com.example.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojo.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Object getUser() {
		UserDTO user = new UserDTO();
		user.setName("dinglei");
		user.setAge(30);
		user.setBirthday(new Date());
		user.setDesc("SpringBoot Test!!!");
		return user;
	}
}
