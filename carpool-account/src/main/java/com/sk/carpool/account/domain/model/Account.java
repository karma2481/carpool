package com.sk.carpool.account.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.carpool.shared.base.AbstractEntity;
import com.sk.carpool.shared.base.AggregateRoot;
import com.sk.carpool.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Account extends AbstractEntity implements AggregateRoot {

	private int gradePoint;

	private String name;
	private String phoneNo;
	private String email;

	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;

	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;

	private Address address;

	public Account(String name, String phoneNo, String email) {
		this(name, phoneNo, email, MemberType.NORMAL, MembershipLevelType.SILVER);
	}

	public Account(String name, String phoneNo, String email, MemberType memberType,
			MembershipLevelType membershipLevelType) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.memberType = memberType;
		this.membershipLevelType = membershipLevelType;
	}

}
