package xyz.wilver.clientes.infrastructure.hibernate.entities.customer

import xyz.wilver.clientes.domain.valueObjects.MovementType
import xyz.wilver.clientes.infrastructure.hibernate.entities.base.HibernateBaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity(name = "CustomerBalance")
@Table(name = "customer_balance", schema = "customer")
class CustomerBalanceHibernate : HibernateBaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    var customer: CustomerHibernate? = null

    @Column(precision = 18, scale = 2)
    var amount: BigDecimal = BigDecimal.ZERO

    @Enumerated(EnumType.ORDINAL)
    var movementType: MovementType = MovementType.DEBIT

}
