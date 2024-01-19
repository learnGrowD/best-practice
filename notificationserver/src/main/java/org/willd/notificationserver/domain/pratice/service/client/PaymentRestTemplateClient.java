package org.willd.notificationserver.domain.pratice.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class PaymentRestTemplateClient {

    private final RestTemplate restTemplate;

    public String getPaymentId(String paymentId) {
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://payment-server/will-d/v1/payment/practice/{paymentId}",
                        HttpMethod.GET,
                        null, String.class, paymentId
                );
        return restExchange.getBody();
    }
}
