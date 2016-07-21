package com.alpha.dao;

import com.alpha.entity.User;

import antlr.collections.List;

public interface UserDAO {
	public List search(User condition);
}
