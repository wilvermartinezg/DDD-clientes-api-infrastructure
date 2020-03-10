package xyz.wilver.clientes.infrastructure.hibernate.repo.common

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.wilver.clientes.infrastructure.hibernate.entities.common.PersonHibernate

@Repository
interface PersonJpaRepository : JpaRepository<PersonHibernate, Long> {
}
