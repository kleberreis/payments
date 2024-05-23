package br.com.olx.payment.api

import br.com.olx.payment.application.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class PaymentControler(
    @Autowired
    val service: PaymentService
) {

    @PostMapping("/notification")
    fun paymentNotification(@RequestBody payment: Payment): Payment {
        service.save(payment)
        return payment
    }
}

data class Payment(
    val adId: String,
    val accountId: String,
    val productKey: String,
    val price: BigDecimal,
    val status: String,
    val orderId: Long
)