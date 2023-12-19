package br.com.olx.activation.domain

import br.com.olx.activation.api.Activation
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Activations(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var productKey: String,
    var adId: String,
    var uuid: String,
    ){

    companion object {
        fun from(activation: Activation): Activations {
            return Activations(
                null,
                activation.productKey,
                activation.adId,
                UUID.randomUUID().toString()
            )
        }
    }

}