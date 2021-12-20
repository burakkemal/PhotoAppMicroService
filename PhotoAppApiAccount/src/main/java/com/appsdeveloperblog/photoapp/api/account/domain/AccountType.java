package com.appsdeveloperblog.photoapp.api.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "accountTypes")
public class AccountType {
	@Id
	@Column(name = "Id")
	private String accountTypeId;

	@Column(name = "accountName")
	private String accountName;
	@Column(name = "price")
	private double price;
	@Column(name = "description")
	private String description;
}
