package br.com.olx.activation.application

import br.com.olx.activation.api.Activation
import br.com.olx.activation.domain.Activations
import br.com.olx.activation.infrastructure.ActivationRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ActivationService(
    @Autowired
    val repository: ActivationRepository
) {

    @Transactional
    fun save(activation: Activation){
        val entity = Activations.from(activation)
        repository.save(entity)
        try{
            mandaPraFila()
        }catch (e: Exception){
            println("mensagem não enviada pra fila")
        }


    }


    fun orquestracao(activation: Activation){
        try{
            save(activation)
        }catch (e: Exception){
            // compensacao, chamar o servico x para desfazer o que foi feito
            // relancar excecao.
        }

    }

    fun mandaPraFila(){
        println("mandei pra fila")
        throw RuntimeException("lascou!")
    }
}