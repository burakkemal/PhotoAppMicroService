package com.appsdeveloperblog.photoapp.api.account.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, String> {
	AccountType findByAccountTypeId(String accountTypeId);
}
