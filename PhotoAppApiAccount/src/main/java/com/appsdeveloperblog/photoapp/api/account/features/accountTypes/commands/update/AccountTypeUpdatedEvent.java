package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update;

import lombok.Data;

@Data
public class AccountTypeUpdatedEvent {
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description;
}
