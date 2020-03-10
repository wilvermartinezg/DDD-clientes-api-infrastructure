package xyz.wilver.clientes.infrastructure.exceptions

class EntityNotFoundException(message: String = "Entidad no encontrada") : Exception(message)

class EntityNotPersistedException(message: String = "Entidad no persistida") : Exception(message)

class InvalidEntityException(message: String = "Entidad no válida"): Exception(message)
