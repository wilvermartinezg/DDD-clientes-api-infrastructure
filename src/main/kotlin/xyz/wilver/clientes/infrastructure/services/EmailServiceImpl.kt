package xyz.wilver.clientes.infrastructure.services

import org.slf4j.LoggerFactory

class EmailServiceImpl : EmailService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun sendEmail(from: String, to: String, body: String) {
        log.info("Enviando email a: {}, contenido de email: {}, enviado por: {}", to, body, from)
    }

}
