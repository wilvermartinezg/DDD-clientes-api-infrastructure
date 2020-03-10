package xyz.wilver.clientes.infrastructure.hibernate.entities.common

import xyz.wilver.clientes.domain.valueObjects.PersonGender
import xyz.wilver.clientes.infrastructure.hibernate.entities.base.HibernateBaseEntity
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Table

@Entity(name = "Person")
@Table(name = "person", schema = "common")
class PersonHibernate(var name: String, var lastName: String) : HibernateBaseEntity() {

    var email = ""
    var birthdate: LocalDate = LocalDate.now()
    var gender: PersonGender = PersonGender.MALE

}
