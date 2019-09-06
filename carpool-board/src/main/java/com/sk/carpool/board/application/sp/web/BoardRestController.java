package com.sk.carpool.board.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.carpool.board.domain.service.BoardService;

@RestController
@RequestMapping("/v1/boards")
public class BoardRestController implements BoardService {
	@Autowired
	private BoardService boardService;

	
	@Override
	@PutMapping("/{id}/purchased")
	public void purchase(@PathVariable("id") Long id) {
		boardService.purchase(id);
	}


}
