package com.example.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.LogininfoMapper;
import com.example.mapper.LogininfoMapperCustom;
import com.example.pojo.Logininfo;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private LogininfoMapper userMapper;
	
	@Autowired
	private LogininfoMapperCustom logininfoMapperCustom;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(Logininfo user) throws Exception {
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		userMapper.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(Logininfo user) {
//		userMapper.updateByPrimaryKeySelective(user);
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Logininfo queryUserById(String userId) {
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Logininfo> queryUserListPaged(Logininfo user, Integer page, Integer pageSize) {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		
		Example example = new Example(Logininfo.class);

		List<Logininfo> userList = userMapper.selectByExample(example);
		
		return userList;
	}
	
	@Override
	public Logininfo queryUserByIdCustom(String id) {
		List<Logininfo> userList = logininfoMapperCustom.queryUserSimplyInfoById(id);
		if (userList != null && !userList.isEmpty()) {
			return (Logininfo)userList.get(0);
		}
		
		return null;
	} 
}
