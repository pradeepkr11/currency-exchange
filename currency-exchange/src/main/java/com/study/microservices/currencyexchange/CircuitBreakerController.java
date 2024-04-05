package com.study.microservices.currencyexchange;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "default")  // tries calling and if there is any error/exception then call 3 times and finally returns error
//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse") //we can also set retry count in application file
//    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleApi(){
        logger.info("Sample api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("https://localhost:8989/dummy-url", String.class);
//        return forEntity.getBody();
        return "sample-api";
    }

    public String hardCodedResponse(Exception e){
        return "fallback-response";
    }
}
