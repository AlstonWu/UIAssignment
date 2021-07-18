package com.ui.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	@JsonProperty("account")
	private String account;

	@JsonProperty("password")
	private String password;

	@JsonProperty("fullname")
	private String fullname;

}
