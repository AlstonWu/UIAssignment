package com.ui.assignment.service;

import java.util.List;

import com.ui.assignment.dto.UserDTO;

public interface UserService {

	/**
	 * Get all Users
	 *
	 * @return UserDTO
	 */
	public List<UserDTO> getUserList();

	/**
	 * Get User by account
	 *
	 * @param account
	 * @return UserDTO
	 */
	public UserDTO getUser(String account);

	/**
	 * Update User
	 *
	 * @param userDTO
	 */
	public void updateUser(UserDTO userDTO);

	/**
	 * Delete User
	 *
	 * @param account
	 */
	public void deleteUser(String account);
}
