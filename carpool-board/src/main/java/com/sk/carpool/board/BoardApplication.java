package com.sk.carpool.board;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.carpool.board.domain.model.Board;
import com.sk.carpool.board.domain.repository.BoardRepository;
import com.sk.carpool.board.domain.service.BoardService;

@SpringBootApplication
@EnableFeignClients
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(BoardRepository boardRepository, @Qualifier("boardLogic") BoardService boardService) {	
		return (args) -> {
			Board board = new Board(8L, 4L);
			boardRepository.save(board);
			boardService.purchase(board.getId());
		};
	}

}