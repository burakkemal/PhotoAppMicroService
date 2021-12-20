package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels;

import lombok.Data;

@Data
public class AccountTypeListRestModel {
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description;
}
