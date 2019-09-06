package com.sk.carpool.account.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.carpool.account.domain.model.Account;

public interface AccountService {
	Account findById(Long id);
	List<Account> findAll();
	Page<Account> findAll(Pageable pageable);
	
	List<Account> findByNameLike(String name);
	List<Account> findByEmailLike(String name);
	
	Account findByEmail(String email);
	
	Account register(Account account);
	Account update(Long id, Account account);

	void delete(Long id);
}
