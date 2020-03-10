package xyz.wilver.clientes.infrastructure.repository

import xyz.wilver.clientes.domain.entities.CustomerBalance
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotFoundException
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotPersistedException
import xyz.wilver.clientes.infrastructure.hibernate.entities.customer.CustomerBalanceHibernate
import xyz.wilver.clientes.infrastructure.hibernate.repo.customer.CustomerBalanceJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.customer.CustomerJpaRepository

class CustomerBalanceRepositoryImpl(
    private val customerJpaRepository: CustomerJpaRepository,
    private val customerBalanceJpaRepository: CustomerBalanceJpaRepository
) : CustomerBalanceRepository {

    override fun create(customerBalance: CustomerBalance) {
        val customerEntity = customerJpaRepository
            .findById(customerBalance.customerId)
            .orElseThrow { EntityNotFoundException("Entidad Customer no encontrada") }

        val balanceEntity = CustomerBalanceHibernate().apply {
            this.customer = customerEntity
            this.amount = customerBalance.amount
            this.movementType = customerBalance.movementType
        }

        customerBalanceJpaRepository.save(balanceEntity)

        customerBalance.apply {
            this.id = balanceEntity.id ?: throw EntityNotPersistedException("Entidad CustomerBalance no persistida")
        }
    }
    
}
