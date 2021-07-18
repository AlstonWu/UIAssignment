package com.ui.assignment.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ui.assignment.dto.UserDTO;

import lombok.Data;

@Entity(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Data
public class UserEntity {

	@Id
	@Column(name = "acct", nullable = false, updatable = false)
	private String account;

	@Column(name = "pwd", nullable = true)
	private String password;

	@Column(name = "fullname", nullable = true)
	private String fullname;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Instant createdTimestamp;

	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private Instant updatedTimestamp;

	@SuppressWarnings("unused")
	private UserEntity() {
		// no-args constructor for spring data JPA
		this(new UserDTO());
	}

	public UserEntity(UserDTO userDTO) {
		this.setAccount(userDTO.getAccount());
		this.setPassword(userDTO.getPassword());
		this.setFullname(userDTO.getFullname());
	}

}
