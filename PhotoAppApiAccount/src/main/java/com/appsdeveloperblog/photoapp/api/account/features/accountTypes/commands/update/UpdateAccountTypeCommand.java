package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAccountTypeCommand {
	@TargetAggregateIdentifier
	private final String accountTypeId;
	private final String accountName;
	private final double price;
	private final String description;
}
