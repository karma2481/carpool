package com.sk.carpool.account;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.sk.carpool.account.domain.model.Account;
import com.sk.carpool.account.domain.model.MemberType;
import com.sk.carpool.account.domain.model.MembershipLevelType;
import com.sk.carpool.account.domain.model.QAccount;
import com.sk.carpool.account.domain.repository.AccountRepository;
import com.sk.carpool.shared.domain.Address;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(AccountRepository accountRepository) {	
		return (args) -> {
			insertAccounts(accountRepository); //초기데이터 적재
			
			executeExample1(accountRepository); //초기데이터 적재
		};
	}

	
	public void insertAccounts(AccountRepository accountRepository) {
		Account account1 = new Account("김종국", "010-7105-1221", "edgar.kim@sk.com");
		account1.setAddress(new Address(56442, "서울시 강동구 둔촌동"));
		accountRepository.save(account1);
		
		Account account2 = new Account("김하나", "010-1251-1225", "김하나@sk.com");
		account2.setAddress(new Address(12354, "서울시 송파구 잠실동"));
		accountRepository.save(account2);
		
		Account account3 = new Account("이둘", "010-5452-7545", "이둘@sk.com");
		account3.setAddress(new Address(78445, "서울시 강남구 일원동"));
		accountRepository.save(account3);
		
		Account account4 = new Account("박셋", "010-7854-9321", "박셋@sk.com");
		account4.setAddress(new Address(78445, "서울시 은평구 불광동"));
		accountRepository.save(account4);
		
		Account account5 = new Account("정넷", "010-8745-3451", "정넷@test.com", MemberType.NORMAL,
				MembershipLevelType.SILVER);
		account5.setAddress(new Address(54427, "서울시 구로구 고척동"));
		accountRepository.save(account5);
		
		Account account6 = new Account("라이더일", "010-5445-4512", "라이더일@test.com", MemberType.NORMAL,
				MembershipLevelType.SILVER);
		account6.setAddress(new Address(12354, "서울시 송파구 잠실동"));
		accountRepository.save(account6);		
		
		Account account7 = new Account("라이더이", "010-2187-3468", "라이더이@sk.com", MemberType.EMP,
				MembershipLevelType.GOLD);
		account7.setAddress(new Address(54427, "서울시 구로구 고척동"));
		accountRepository.save(account7);

		Account account8 = new Account("라이더삼", "010-4523-9854", "라이더삼@sk.com", MemberType.EMP,
				MembershipLevelType.GOLD);
		account8.setAddress(new Address(78445, "서울시 강남구 일원동"));
		accountRepository.save(account8);
	}
	
	
	public void executeExample1(AccountRepository accountRepository) {
		Predicate predicate = QAccount.account.email.like("%test.com%");
		List<Account> accountList = accountRepository.findAll(predicate);
		
		System.out.println("executeExample1 Result: " + accountList.toString());
	}	

}
