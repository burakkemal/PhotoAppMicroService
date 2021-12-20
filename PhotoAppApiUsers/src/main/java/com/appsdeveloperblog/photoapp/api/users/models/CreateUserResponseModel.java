package com.appsdeveloperblog.photoapp.api.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseModel {
	private String firstName;
	private String lastName;
	private String email;
	private String userId;
}
