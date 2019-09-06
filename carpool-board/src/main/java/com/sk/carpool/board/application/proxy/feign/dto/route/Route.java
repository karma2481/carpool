package com.sk.carpool.board.application.proxy.feign.dto.route;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Route {

	private Long id;

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