package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import java.util.NoSuchElementException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;

@FeignClient(name = "${car.name:car}", url = "${car.url:http://localhost:8080}")
public interface CarApiClient extends CarApi {
    String CORE = "core";

	
	  @Override
	  
	  @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
	  
	  @RateLimiter(name = CORE)
	  
	  @GetMapping(value = "/cars/{id}") ResponseEntity<CarDTO>
	  getCarById(@PathVariable("id") Integer id);
	  
	  default ResponseEntity<CarDTO> coreFallback(Integer id,
	  CallNotPermittedException exception) { throw new NoSuchElementException(); }
	  
	  default ResponseEntity<CarDTO> coreFallback(Integer id, Exception exception)
	  { throw new RuntimeException(); }
	 
}