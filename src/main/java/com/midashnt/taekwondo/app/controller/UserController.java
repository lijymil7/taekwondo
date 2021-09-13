package com.midashnt.taekwondo.app.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.midashnt.taekwondo.app.dto.User;
import com.midashnt.taekwondo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

	protected UserService userService;
	protected Gson gson = new Gson();

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/create-user")
	public String createUser(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			User user = new User();
			user.setUserId((String)data.get(User.KEY_USER_ID));
			user.setUserPassword((String)data.get(User.KEY_USER_PASSWORD));
			user.setUserName((String)data.get(User.KEY_USER_NAME));
			user.setUserAuthority(Integer.parseInt((String)data.get(User.KEY_USER_AUTHORITY)));

			userService.createUser(user);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@PutMapping(value = "/update-user")
	public String updateUser(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			User user = new User();
			user.setUserIndex(Integer.parseInt((String)data.get(User.KEY_USER_INDEX)));
			user.setUserId((String)data.get(User.KEY_USER_ID));
			user.setUserPassword((String)data.get(User.KEY_USER_PASSWORD));
			user.setUserName((String)data.get(User.KEY_USER_NAME));
			user.setUserAuthority(Integer.parseInt((String)data.get(User.KEY_USER_AUTHORITY)));

			userService.updateUser(user);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@DeleteMapping(value = "/delete-user/{userIndex}")
	public String deleteUser(@PathVariable(User.KEY_USER_INDEX) int userIndex, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			userService.deleteUser(userIndex);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

}