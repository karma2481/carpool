package com.sk.carpool.account.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.carpool.account.domain.model.Account;

@RepositoryRestResource
public interface AccountRepository
		extends PagingAndSortingRepository<Account, Long>, QueryDslPredicateExecutor<Account> {
	
	List<Account> findAll();
	
	List<Account> findAll(Predicate predicate);
	
	List<Account> findByNameLike(@Param("name") String name);
	
	@Query("SELECT a from Account a where a.phoneNo like %?1%")
	List<Account> findByPhoneNoLike(@Param("phoneNo") String phoneNo);	
	
	Account findByEmail(@Param("email") String email);
	
	List<Account> findByEmailLike(@Param("email") String email);

	List<Account> findByAddressZipCode(@Param("zipCode") Integer zipCode);

	@Query("select a from Account a where a.address.homeAddress like %?1%")
	List<Account> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);

}
