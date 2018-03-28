package com.dao;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.*;

public interface UserDao {
	public List<User> getAllUsers();

	public boolean addUser(User user);

	public User getUser(String email);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	public User findById(int id);

	public User findBySSO(String sso);

	public boolean checkLogin(User user);

	public boolean updateOnlineStatus(String onlineStatus, User user);

}
