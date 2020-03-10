package xyz.wilver.clientes.infrastructure.hibernate.entities.customer

import xyz.wilver.clientes.infrastructure.hibernate.entities.base.HibernateBaseEntity
import xyz.wilver.clientes.infrastructure.hibernate.entities.common.PersonHibernate
import xyz.wilver.clientes.infrastructure.hibernate.entities.company.CompanyHibernate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity(name = "Customer")
@Table(name = "customer", schema = "customer")
class CustomerHibernate : HibernateBaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    var person: PersonHibernate? = null

    @ManyToOne(fetch = FetchType.LAZY)
    var company: CompanyHibernate? = null

}
