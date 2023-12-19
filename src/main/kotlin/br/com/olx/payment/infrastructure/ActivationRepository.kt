package br.com.olx.payment.infrastructure

import br.com.olx.payment.domain.Payments
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivationRepository : CrudRepository<Payments, Long>{

    fun findByAdId(adId: String)

    fun findByAdIdAndProductKey(adId: String, productKey: String)
}
