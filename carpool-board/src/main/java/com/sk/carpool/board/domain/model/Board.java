package com.sk.carpool.board.domain.model;

import javax.persistence.Entity;

import com.sk.carpool.shared.base.AbstractEntity;
import com.sk.carpool.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)

public class Board extends AbstractEntity implements AggregateRoot {
	
	private Long riderAccountId;
	private Long routeId;
	
	private String boardYN = "N";

	public Board(Long riderAccountId, Long routeId) {
		this.riderAccountId = riderAccountId;
		this.routeId = routeId;
	}

}
