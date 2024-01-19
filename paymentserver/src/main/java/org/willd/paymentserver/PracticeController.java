package org.willd.paymentserver;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("will-d/v1/payment/practice")
public class PracticeController {

    @GetMapping("{paymentId}")
    public String getPaymentId(@PathVariable String paymentId) {
        return "Hello...." + paymentId;
    }
}
