package org.willd.notificationserver.domain.pratice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.willd.notificationserver.domain.pratice.service.client.PaymentDiscoveryClient;
import org.willd.notificationserver.domain.pratice.service.client.PaymentFeignClient;
import org.willd.notificationserver.domain.pratice.service.client.PaymentRestTemplateClient;

//
@RequiredArgsConstructor
@RestController
@RequestMapping("will-d/v1/notification/practice")
public class PracticeController {
    private final PaymentDiscoveryClient paymentDiscoveryClient;
    private final PaymentRestTemplateClient paymentRestTemplateClient;
    private final PaymentFeignClient paymentFeignClient;

    @GetMapping("{paymentId}")
    public String test(@PathVariable String paymentId) {
        return paymentDiscoveryClient.getPayment(paymentId) + " ::: " + paymentRestTemplateClient.getPaymentId(paymentId) + " +++ " + paymentFeignClient.getPayment(paymentId);
    }

    private String fallBackMethodTest(String paymentId, Throwable tx) {
        return "Hello..";
    }
}

//보안, 로깅 -> 모니터링
//공통적으로 사용하는 모듈에 대해서는 implement를 할 수 있도록 한다.
//
