package com.sk.carpool.route;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.carpool.route.domain.model.Route;
import com.sk.carpool.route.domain.repository.RouteRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class RouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(RouteRepository accountRepository) {	
		return (args) -> {
			insertRoutes(accountRepository);
			displayRoutes(accountRepository);
		};
	}

	public void insertRoutes(RouteRepository routeRepository) throws Exception {
		Route route1 = new Route(1L, "서울시 강동구 둔촌동", "서울시 강동구 성내동", "제네시스", 4,
				new SimpleDateFormat("yyyyMMdd HHmm").parse("20190830 0800"));
		routeRepository.save(route1);
		
		Route route2 = new Route(2L, "서울시 송파구 잠실동", "경기도 분당구 정자동", "그랜저", 4,
				new SimpleDateFormat("yyyyMMdd HHmm").parse("20190830 0700"));
		routeRepository.save(route2);
		
		Route route3 = new Route(4L, "서울시 은평구 불광동", "서울 분당구 삼평동", "BMW", 2,
				new SimpleDateFormat("yyyyMMdd HHmm").parse("20190830 0730"));
		routeRepository.save(route3);		
		
		Route route4 = new Route(3L, "서울시 강남구 일원동", "경기도 분당구 정자동", "BENZ", 1,
				new SimpleDateFormat("yyyyMMdd HHmm").parse("20190830 0730"));
		routeRepository.save(route4);		
	}
	
	public void displayRoutes(RouteRepository routeRepository) {
		System.out.println("displayRoutes start ******************************************");
		
		Iterable<Route> routeList = routeRepository.findAll();
		for(Route route : routeList) {
			System.out.println(route.toString());	
		}
		
		System.out.println("displayRoutes end ******************************************");
	}
	
}
