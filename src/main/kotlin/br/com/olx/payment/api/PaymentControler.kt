package br.com.olx.activation.api

import br.com.olx.activation.application.ActivationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ActivationControler(
    @Autowired
    val service: ActivationService
) {

    @PostMapping("/")
    fun createActivation(@RequestBody activation: Activation): Activation {
        service.save(activation)
        return activation
    }
}

data class Activation(
    val adId: String,
    val productKey: String)