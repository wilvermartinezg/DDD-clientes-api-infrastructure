package xyz.wilver.clientes.infrastructure.mapper

import xyz.wilver.clientes.domain.entities.Customer
import xyz.wilver.clientes.domain.valueObjects.Person
import xyz.wilver.clientes.infrastructure.exceptions.EntityNotFoundException
import xyz.wilver.clientes.infrastructure.exceptions.InvalidEntityException
import xyz.wilver.clientes.infrastructure.hibernate.entities.customer.CustomerHibernate

class CustomerMapper {

    fun fromCustomerHibernate(customerHibernate: CustomerHibernate): Customer {
        val personEntity = customerHibernate.person ?: throw EntityNotFoundException("Entidad Person no encontrada")

        val person = Person(personEntity.name, personEntity.lastName).apply {
            this.email = personEntity.email
            this.birthdate = personEntity.birthdate
            this.gender = personEntity.gender
        }

        val companyId = customerHibernate.company?.id
            ?: throw EntityNotFoundException("La entidad Customer no tiene una entidad Company asociada")

        return Customer(person, companyId).apply {
            this.id = customerHibernate.id ?: throw InvalidEntityException("Entidad customer no valida")
        }
    }

}
