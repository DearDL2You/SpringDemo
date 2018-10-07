package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.UserDTO;
import com.example.utils.JsonUtils;
import com.example.utils.RedisOperator;


@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public IMoocJSONResult hello() {
		strRedis.opsForValue().set("userName", "dinglei128");
		
		UserDTO user = new UserDTO();
		user.setName("dinglei");
		user.setAge(31);
		user.setBirthday(new Date());
		user.setDesc("*** SpringBoot Test!!!");
		
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

		UserDTO jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), UserDTO.class);

		return IMoocJSONResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public IMoocJSONResult getJsonList() {
		
		UserDTO user = new UserDTO();
		user.setAge(18);
		user.setName("慕课网");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		UserDTO u1 = new UserDTO();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		UserDTO u2 = new UserDTO();
		u2.setAge(17);
		u2.setName("hello imooc");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<UserDTO> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = (String) redis.get("json:info:userlist");
		List<UserDTO> userListBorn = JsonUtils.jsonToList(userListJson, UserDTO.class);
		
		return IMoocJSONResult.ok(userListBorn);
	}
}
