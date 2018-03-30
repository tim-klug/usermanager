package de.usermanager.contracts

import org.springframework.http.ResponseEntity

interface CrudService<T> {
    fun findAll(): ResponseEntity<List<T>>
    fun findById(id: Long): ResponseEntity<T>
}