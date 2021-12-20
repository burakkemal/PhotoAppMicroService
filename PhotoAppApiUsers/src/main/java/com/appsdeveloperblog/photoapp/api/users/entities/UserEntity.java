package com.appsdeveloperblog.photoapp.api.users.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@Column(name = "id")
	private String userId;
	
	@Column(name = "firstName", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "lastName", nullable = false,length = 50 )
	private String lastName;
	
	@Column(name = "email", nullable = false,length = 100, unique = true)
	private String email;
	
	@Column(name = "password")
	private String encryptedPassword;
}
