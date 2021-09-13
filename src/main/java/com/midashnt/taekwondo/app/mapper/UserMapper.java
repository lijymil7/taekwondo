package com.midashnt.taekwondo.app.mapper;
import com.midashnt.taekwondo.app.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface UserMapper {
	String createUser(User user);
	void updateUser(User user);
	User getUserByIndex(int userIndex);
	void deleteUser(int userIndex);
}