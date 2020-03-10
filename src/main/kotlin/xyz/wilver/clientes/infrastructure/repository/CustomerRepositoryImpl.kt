package xyz.wilver.clientes.infrastructure.repository

import xyz.wilver.clientes.domain.entities.Customer
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotFoundException
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotPersistedException
import xyz.wilver.clientes.infrastructure.hibernate.entities.common.PersonHibernate
import xyz.wilver.clientes.infrastructure.hibernate.entities.customer.CustomerHibernate
import xyz.wilver.clientes.infrastructure.hibernate.repo.common.PersonJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.company.CompanyJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.customer.CustomerJpaRepository
import xyz.wilver.clientes.infrastructure.mapper.CustomerMapper

class CustomerRepositoryImpl(
    private val customerJpaRepository: CustomerJpaRepository,
    private val personJpaRepository: PersonJpaRepository,
    private val companyJpaRepository: CompanyJpaRepository
) : CustomerRepository {

    override fun create(customer: Customer) {
        val companyEntity = companyJpaRepository
            .findById(customer.companyId)
            .orElseThrow { EntityNotFoundException("Entidad Company no encontrada") }

        val personEntity = PersonHibernate(customer.person.name, customer.person.lastName).apply {
            this.email = customer.person.email
            this.birthdate = customer.person.birthdate
            this.gender = customer.person.gender
        }

        personJpaRepository.save(personEntity)

        val customerEntity = CustomerHibernate().apply {
            this.person = personEntity
            this.company = companyEntity
        }

        customerJpaRepository.save(customerEntity)

        customer.apply {
            this.id = customerEntity.id ?: throw EntityNotPersistedException("Entidad Customer no persistida")
        }
    }

    override fun update(customer: Customer) {
        val customerEntity = customerJpaRepository
            .findById(customer.id)
            .orElseThrow { EntityNotFoundException("Entidad Customer no encontrada") }

        val personEntity = customerEntity.person ?: throw EntityNotFoundException("Entidad Person no encontrada")

        personEntity.apply {
            this.name = customer.person.name
            this.lastName = customer.person.lastName
            this.email = customer.person.email
            this.gender = customer.person.gender
            this.birthdate = customer.person.birthdate
        }

        personJpaRepository.save(personEntity)
    }

    override fun findById(id: Long): Customer? {
        val entity = customerJpaRepository.findById(id)

        return when {
            entity.isPresent -> CustomerMapper().fromCustomerHibernate(entity.get())
            else -> null
        }
    }

}
