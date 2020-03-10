package xyz.wilver.clientes.infrastructure.hibernate.repo.company

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.wilver.clientes.infrastructure.hibernate.entities.company.CompanyHibernate

@Repository
interface CompanyJpaRepository : JpaRepository<CompanyHibernate, Long> {
}
