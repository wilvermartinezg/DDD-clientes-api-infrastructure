package xyz.wilver.clientes.infrastructure.hibernate.repo.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.wilver.clientes.infrastructure.hibernate.entities.customer.CustomerBalanceHibernate

@Repository
interface CustomerBalanceJpaRepository : JpaRepository<CustomerBalanceHibernate, Long> {
}
