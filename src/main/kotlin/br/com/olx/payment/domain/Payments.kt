package br.com.olx.payment.domain

import br.com.olx.payment.api.Payment
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.util.UUID

@Entity
class Payments(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var productKey: String,
    var adId: String,
    var accountId: String,
    var price: BigDecimal,
    var status: String,
    var orderId: Long,
    var uuid: String,
    ){

    companion object {
        fun from(payment: Payment): Payments {
            return Payments(
                null,
                payment.productKey,
                payment.adId,
                payment.accountId,
                payment.price,
                payment.status,
                payment.orderId,
                UUID.randomUUID().toString()
            )
        }
    }
}
