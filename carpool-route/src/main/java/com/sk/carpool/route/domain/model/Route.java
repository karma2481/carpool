package com.sk.carpool.route.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.carpool.shared.base.AbstractEntity;
import com.sk.carpool.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Route extends AbstractEntity implements AggregateRoot {

	private int riderLimitCnt;
	private int riderRegCnt;

	private Long accountId;

	private Date departureTime;

	private String departureAddr;
	private String arrivalAddr;
	private String carInfo;

	@Enumerated(EnumType.STRING)
	private RouteStatus routeStatus = RouteStatus.RECRUIT;

	public Route(Long accountId, String departureAddr, String arrivalAddr, String carInfo, int riderLimitCnt,
			Date departureTime) {
		this.accountId = accountId;
		this.departureAddr = departureAddr;
		this.arrivalAddr = arrivalAddr;
		this.carInfo = carInfo;
		this.riderLimitCnt = riderLimitCnt;
		this.departureTime = departureTime;
	}

}
