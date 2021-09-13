package com.midashnt.taekwondo.app.service;
import com.midashnt.taekwondo.app.dto.User;
public interface UserService {
	void createUser(User user);
	void updateUser(User user);
	User getUserByIndex(int userIndex);
	void deleteUser(int userIndex);
}