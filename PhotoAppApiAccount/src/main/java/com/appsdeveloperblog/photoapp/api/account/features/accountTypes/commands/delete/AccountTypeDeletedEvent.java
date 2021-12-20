package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import lombok.Data;

@Data
public class AccountTypeDeletedEvent {
	
	private String accountTypeId;
}
