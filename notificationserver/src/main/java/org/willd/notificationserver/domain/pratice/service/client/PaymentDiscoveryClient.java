package org.willd.notificationserver.domain.pratice.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PaymentDiscoveryClient {

    private final DiscoveryClient discoveryClient;

    public String getPayment(String paymentId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("payment-server");

        if (instances.isEmpty()) return null;
        String serverUri = String.format("%s/will-d/v1/payment/practice/%s", instances.get(0).getUri().toString(), paymentId);
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        serverUri,
                        HttpMethod.GET,
                        null, String.class, paymentId
                );
        return restExchange.getBody();
    }
}
