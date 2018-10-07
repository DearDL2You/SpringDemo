package com.example.service;

import java.util.List;

import com.example.pojo.Logininfo;

public interface UserService {

	public void saveUser(Logininfo user) throws Exception;

	public void updateUser(Logininfo user);

	public void deleteUser(String userId);

	public Logininfo queryUserById(String userId);

	public List<Logininfo> queryUserListPaged(Logininfo user, Integer page, Integer pageSize);

	public Logininfo queryUserByIdCustom(String userId);

}
