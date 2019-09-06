package com.sk.carpool.route.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.carpool.route.domain.model.Route;

@RepositoryRestResource
public interface RouteRepository extends PagingAndSortingRepository<Route, Long>,
                                           QueryDslPredicateExecutor<Route> {
	List<Route> findAll();

	List<Route> findAll(Predicate predicate);

	@Query("select a from Route a where a.departureAddr like %?1%")
	List<Route> findByDepartureAddrLike(@Param("departureAddr") String departureAddr);

	@Query("select a from Route a where a.arrivalAddr like %?1%")
	List<Route> findByArrivalAddrLike(@Param("arrivalAddr") String arrivalAddr);
}
