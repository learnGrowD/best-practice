package org.willd.notificationserver.domain.pratice.service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("payment-server")
public interface PaymentFeignClient {
    @GetMapping("will-d/v1/payment/practice/{paymentId}")
    String getPayment(@PathVariable String paymentId);
}

//gay
//auth
//Testcode
//WebFlux -> Reactive // DB 반응형 MongoDB // Mysql
//CI/CD 젠킨스

//auth
//message
//쿠버네티스


