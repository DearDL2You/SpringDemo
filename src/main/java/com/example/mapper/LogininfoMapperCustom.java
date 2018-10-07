package com.example.mapper;

import java.util.List;

import com.example.pojo.Logininfo;
import com.example.utils.MyMapper;

public interface LogininfoMapperCustom extends MyMapper<Logininfo> {
	
	public List<Logininfo> queryUserSimplyInfoById(String id);
}