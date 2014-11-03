package com.bondar.RestLogin.data;

import com.bondar.RestLogin.model.User;

public interface UserDao {
	User findUserByUsername(String name);
	User findUserById(long id);
}
