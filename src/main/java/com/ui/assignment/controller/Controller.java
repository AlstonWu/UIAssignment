package com.ui.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ui.assignment.dto.UserDTO;
import com.ui.assignment.service.UserService;

@RestController
public class Controller {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> queryUsers() {
		List<UserDTO> users = userService.getUserList();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/user/{account}")
	public ResponseEntity<UserDTO> queryUser(@PathVariable(value = "account", required = true) final String account) {
		UserDTO user = userService.getUser(account);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody final UserDTO userDTO) {
		userService.updateUser(userDTO);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/user/{account}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "account", required = true) final String account) {
		userService.deleteUser(account);
		return ResponseEntity.ok().build();
	}
}