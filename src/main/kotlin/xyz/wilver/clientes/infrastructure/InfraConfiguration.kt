package xyz.wilver.clientes.infrastructure

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import xyz.wilver.clientes.infrastructure.hibernate.repo.common.PersonJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.company.CompanyJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.customer.CustomerBalanceJpaRepository
import xyz.wilver.clientes.infrastructure.hibernate.repo.customer.CustomerJpaRepository
import xyz.wilver.clientes.infrastructure.repository.CustomerBalanceRepository
import xyz.wilver.clientes.infrastructure.repository.CustomerBalanceRepositoryImpl
import xyz.wilver.clientes.infrastructure.repository.CustomerRepository
import xyz.wilver.clientes.infrastructure.repository.CustomerRepositoryImpl

@Configuration
@EnableJpaRepositories(basePackages = ["xyz.wilver.clientes.infrastructure.hibernate.repo"])
@EntityScan(value = ["xyz.wilver.clientes.infrastructure.hibernate.entities"])
class InfraConfiguration {

    // repositorios
    @Bean
    fun customerRepository(
        customerJpaRepository: CustomerJpaRepository,
        personJpaRepository: PersonJpaRepository,
        companyJpaRepository: CompanyJpaRepository
    ): CustomerRepository {
        return CustomerRepositoryImpl(customerJpaRepository, personJpaRepository, companyJpaRepository)
    }

    @Bean
    fun customerBalanceRepository(
        customerJpaRepository: CustomerJpaRepository,
        customerBalanceJpaRepository: CustomerBalanceJpaRepository
    ): CustomerBalanceRepository {
        return CustomerBalanceRepositoryImpl(customerJpaRepository, customerBalanceJpaRepository)
    }



}
