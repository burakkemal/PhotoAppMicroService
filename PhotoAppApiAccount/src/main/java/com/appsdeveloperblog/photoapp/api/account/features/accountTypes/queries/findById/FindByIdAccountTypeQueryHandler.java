package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findById;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component
public class FindByIdAccountTypeQueryHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public FindByIdAccountTypeQueryHandler(AccountTypeRepository accountTypeRepository) {
		super();
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@QueryHandler
	public AccountTypeListRestModel findByIdAccountType(FindByIdAccountTypeQuery findByIdAccountTypeQuery) {
		AccountType accountTypes=this.accountTypeRepository.findByAccountTypeId(findByIdAccountTypeQuery.getAccountTypeId());
		AccountTypeListRestModel result=new AccountTypeListRestModel();
		BeanUtils.copyProperties(accountTypes, result);
		return result;
	}
}
