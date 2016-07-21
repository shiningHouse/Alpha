package com.alpha.biz.impl;

import java.util.List;

import com.alpha.biz.UserBiz;
import com.alpha.dao.UserDAO;
import com.alpha.entity.User;

public class UserBizImpl implements UserBiz{

	private UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public List login(User condition) {
		
		return (List) userDAO.search(condition);
	}

}
