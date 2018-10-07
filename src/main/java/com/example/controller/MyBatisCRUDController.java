package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.Logininfo;
import com.example.service.UserService;



@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception {
		
		
		Random random = new Random();
		int i = random.nextInt(1000);
		System.out.println("随机数为：" + i);
		Long userId = (long) i;
		
		Logininfo user = new Logininfo();
		user.setId(userId);
		user.setUsername("dinglei" + new Date());
		user.setPassword("abc123");
		user.setState(5);
		userService.saveUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		Logininfo user = new Logininfo();
		long lid = 1L;  
		user.setId(lid);
		user.setUsername("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setState(5);
		userService.updateUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
//	
//	@RequestMapping("/deleteUser")
//	public IMoocJSONResult deleteUser(String userId) {
//		
//		userService.deleteUser(userId);
//		
//		return IMoocJSONResult.ok("删除成功");
//	}
//	
//	@RequestMapping("/queryUserById")
//	public IMoocJSONResult queryUserById(String userId) {
//		
//		return IMoocJSONResult.ok(userService.queryUserById(userId));
//	}
//	
//	@RequestMapping("/queryUserList")
//	public IMoocJSONResult queryUserList() {
//		
//		SysUser user = new SysUser();
//		user.setUsername("imooc");
//		user.setNickname("lee");
//		
//		List<SysUser> userList = userService.queryUserList(user);
//		
//		return IMoocJSONResult.ok(userList);
//	}
//	
	@RequestMapping("/queryUserListPaged")
	public IMoocJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 5;
		
		Logininfo user = new Logininfo();
//		user.setNickname("lee");
		
		List<Logininfo> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
//	
//	@RequestMapping("/saveUserTransactional")
//	public IMoocJSONResult saveUserTransactional() {
//		
//		String userId = sid.nextShort();
//		
//		SysUser user = new SysUser();
//		user.setId(userId);
//		user.setUsername("lee" + new Date());
//		user.setNickname("lee" + new Date());
//		user.setPassword("abc123");
//		user.setIsDelete(0);
//		user.setRegistTime(new Date());
//		
//		userService.saveUserTransactional(user);
//		
//		return IMoocJSONResult.ok("保存成功");
//	}
}
