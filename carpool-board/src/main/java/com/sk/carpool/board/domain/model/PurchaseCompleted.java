package com.sk.carpool.board.domain.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PurchaseCompleted implements Serializable {
	
	private static final long serialVersionUID = -301093781636200955L;
	
	private Long id; 
	private Board board;
	
}
