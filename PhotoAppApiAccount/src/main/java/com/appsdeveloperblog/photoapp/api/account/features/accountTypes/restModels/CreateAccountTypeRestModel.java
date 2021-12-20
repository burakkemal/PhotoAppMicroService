package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels;



import lombok.Data;

@Data
public class CreateAccountTypeRestModel {
	
	private String accountName;
	private double price;
	private String description;
}
