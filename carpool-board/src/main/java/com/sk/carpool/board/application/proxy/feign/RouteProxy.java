package com.sk.carpool.board.application.proxy.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sk.carpool.board.application.proxy.feign.dto.route.Route;

@Service
public class RouteProxy {
 
	@Autowired
	private RouteClient routeClient;
	
	public Route findRoute(Long id) {
		return routeClient.findRoute(id);
	}

	public Collection<Route> findAllRoutes() {
		return routeClient.findAllRoutes().getContent();
	}
	
	public Route routesUpdate(Long id, Route route) {
		return routeClient.routesUpdate(id, route);
	}	
	


	@FeignClient(name="routes", url="http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface RouteClient {
		@GetMapping("routes/{id}")
		Route findRoute(@PathVariable("id") Long id);
		
		@GetMapping("routes")
		Resources<Route> findAllRoutes();

		@PutMapping("routes/{id}")
		Route routesUpdate(@PathVariable("id") Long id, @RequestBody Route routes);
	}
	
}

