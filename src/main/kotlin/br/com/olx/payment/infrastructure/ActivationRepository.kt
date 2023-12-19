package br.com.olx.activation.infrastructure

import br.com.olx.activation.domain.Activations
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivationRepository : CrudRepository<Activations, Long>{

    fun findByAdId(adId: String)

    fun findByAdIdAndProductKey(adId: String, productKey: String)
}
