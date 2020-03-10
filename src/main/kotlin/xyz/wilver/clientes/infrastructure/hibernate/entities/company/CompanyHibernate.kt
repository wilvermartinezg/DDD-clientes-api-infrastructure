package xyz.wilver.clientes.infrastructure.hibernate.entities.company

import xyz.wilver.clientes.infrastructure.hibernate.entities.base.HibernateBaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity(name = "Company")
@Table(name = "company", schema = "company")
data class CompanyHibernate(var companyName: String, var companyCode: String) : HibernateBaseEntity()
