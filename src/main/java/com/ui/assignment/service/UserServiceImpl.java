package com.ui.assignment.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ui.assignment.dto.UserDTO;
import com.ui.assignment.entities.UserEntity;
import com.ui.assignment.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<UserDTO> getUserList() {
		log.info("Query user list.");
		List<UserDTO> users = Lists.newArrayList();
		usersRepository.findAll().forEach(data -> {
			users.add(entityConvertToDTO(data));
		});
		return users;
	}

	@Override
	public UserDTO getUser(String account) {
		log.info("Query user by account.");
		Optional<UserEntity> data = usersRepository.findById(account);
		if (data.isPresent())
			return entityConvertToDTO(data.get());
		else
			return new UserDTO();
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		log.info("Update user.");
		usersRepository.save(new UserEntity(userDTO));
	}

	@Override
	public void deleteUser(String account) {
		log.info("Delete user.");
		usersRepository.deleteById(account);
	}

	private UserDTO entityConvertToDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();

		if (StringUtils.isNotBlank(userEntity.getAccount()))
			userDTO.setAccount(userEntity.getAccount());

		if (StringUtils.isNotBlank(userEntity.getPassword()))
			userDTO.setPassword(userEntity.getPassword());

		if (StringUtils.isNotBlank(userEntity.getFullname()))
			userDTO.setFullname(userEntity.getFullname());

		return userDTO;
	}

}
