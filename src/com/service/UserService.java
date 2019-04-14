package com.service;
 
import java.util.List;

import javax.annotation.Resource;
 
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;
 
@Service("userService")
public class UserService {
	@Resource
	private UserMapper dao;
	/*
	* 通过id获取数据
	*/
	public User findById(String id)throws Exception{
		return (User)dao.selectByPrimaryKey(id);
	}
	//通过学校获取数据
	public List<User> findBySchool(String school)throws Exception{
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andSchoolEqualTo(school);
		return dao.selectByExample(example);
	}
}