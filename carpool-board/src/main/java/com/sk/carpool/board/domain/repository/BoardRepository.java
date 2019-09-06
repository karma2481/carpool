package com.sk.carpool.board.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.carpool.board.domain.model.Board;

@RepositoryRestResource
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {

}