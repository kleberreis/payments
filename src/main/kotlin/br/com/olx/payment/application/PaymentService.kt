package br.com.olx.payment.application

import br.com.olx.payment.api.Payment
import br.com.olx.payment.domain.Activation
import br.com.olx.payment.domain.Payments
import br.com.olx.payment.infrastructure.ActivationRepository
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.messaging.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.kafka.support.KafkaHeaders

@Service
class PaymentService(
    @Autowired
    val repository: ActivationRepository,
    @Value("\${kafka.topics.product}") val topic: String,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    
    @Transactional
    fun save(payment: Payment){
        val entity = Payments.from(payment)
        repository.save(entity)
        //try{
            //sendToActivation(payment)
            mandaPraFila(payment)
        //}catch (e: Exception){
            println("mensagem não enviada para activations")
        //}
    }

    fun mandaPraFila(payload: Payment){
        val message: Message<Payment> = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader("X-Custom-Header", "Custom header here")
                .build()
        kafkaTemplate.send(message)
        // log.info("Message sent with success")
        println("mandei pra fila")
        // throw RuntimeException("lascou!")
    }

    /*fun sendToActivation(payment: Payment) {
        val createActivationUrl = "http://localhost:8080"
        val restTemplate = RestTemplate()
        val activation = Activation(payment.productKey, payment.adId)

        restTemplate.postForEntity(createActivationUrl, activation, String.javaClass)
    }*/
}