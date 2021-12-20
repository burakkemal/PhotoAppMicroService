package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;


@Component
public class AccountTypeUpdateEventsHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeUpdateEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	@EventHandler
	public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeUpdatedEvent, accountType);
		this.accountTypeRepository.save(accountType);
	}
}
