package com.midashnt.taekwondo.app.service;
import com.midashnt.taekwondo.app.dto.User;
import com.midashnt.taekwondo.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService {
	protected UserMapper userMapper;
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void createUser(User user) {
		userMapper.createUser(user);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public User getUserByIndex(int userIndex) {
		return userMapper.getUserByIndex(userIndex);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteUser(int userIndex) {
		userMapper.deleteUser(userIndex);
	}
}