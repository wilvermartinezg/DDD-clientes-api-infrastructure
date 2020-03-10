package xyz.wilver.clientes.infrastructure.hibernate.entities.base

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class HibernateBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var createdAt: LocalDateTime = LocalDateTime.now()

    var createdBy: String = ""

    var modifiedAt: LocalDateTime? = LocalDateTime.now()

    var modifiedBy: String? = ""

    var active: Boolean = true

}
