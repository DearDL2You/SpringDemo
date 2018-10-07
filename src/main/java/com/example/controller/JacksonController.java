package com.example.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.UserDTO;

@RestController
@RequestMapping("/hello")
public class JacksonController {
	
	@RequestMapping("/getUserJson")
	public IMoocJSONResult getUserJson() {
		UserDTO user = new UserDTO();
		user.setName("dinglei");
		user.setAge(31);
		user.setBirthday(new Date());
		user.setDesc("*** SpringBoot Test!!!");
		return IMoocJSONResult.ok(user);
	}
}
