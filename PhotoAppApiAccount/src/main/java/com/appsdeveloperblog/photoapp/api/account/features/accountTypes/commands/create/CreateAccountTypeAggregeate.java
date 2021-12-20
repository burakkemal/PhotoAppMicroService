package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateAccountTypeAggregeate {

	@AggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description; // evente konu olan datalarımız bunlar bu datalar eventle birlikte gidecek

	public CreateAccountTypeAggregeate() {

	}

	@CommandHandler
	public CreateAccountTypeAggregeate(CreateAccountTypeCommand createAccountTypeCommand) {
		// validation
		if (createAccountTypeCommand.getPrice() < 0) {
			throw new IllegalArgumentException("Fiyat sıfırdan küçük olamaz");
		}
		// Business

		// Event fire
		AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();
		// model mapper, builder, bean utils alternatifleri kullanılabilir
		BeanUtils.copyProperties(createAccountTypeCommand, accountTypeCreatedEvent);

		AggregateLifecycle.apply(accountTypeCreatedEvent);
	}

	@EventSourcingHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		this.accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
		this.accountName = accountTypeCreatedEvent.getAccountName();
		this.description = accountTypeCreatedEvent.getDescription();
		this.price = accountTypeCreatedEvent.getPrice();
	}

}
