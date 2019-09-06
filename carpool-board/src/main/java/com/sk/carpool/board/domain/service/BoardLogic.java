package com.sk.carpool.board.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.carpool.board.application.proxy.feign.RouteProxy;
import com.sk.carpool.board.application.proxy.feign.dto.route.Route;
import com.sk.carpool.board.application.proxy.feign.dto.route.RouteStatus;
import com.sk.carpool.board.domain.model.Board;
import com.sk.carpool.board.domain.repository.BoardRepository;

@Service("boardLogic")
public class BoardLogic implements BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private RouteProxy routetProxy;
	
	public void purchase(Long boardId) {
		Board board = boardRepository.findOne(boardId);
		
		if (board == null) {
			System.err.println("no purchase");
			return;
		}

		Route route = routetProxy.findRoute(board.getRouteId());
		
		if ( !RouteStatus.RECRUIT.equals(route.getRouteStatus()) ) {
			System.err.println(route.getRouteStatus() + ": already FIN_READY, END, CANCEL");
			return;
		}

		route.setRiderRegCnt(route.getRiderRegCnt() + 1);
		
		if (route.getRiderLimitCnt() == route.getRiderRegCnt())
			route.setRouteStatus(RouteStatus.FIN_READY);
		
		routetProxy.routesUpdate(route.getId(), route);
		
		board.setBoardYN("Y");
		boardRepository.save(board);
	}
	

}
