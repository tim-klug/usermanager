package de.usermanager.service

import de.usermanager.contracts.CrudService
import de.usermanager.controller.resources.UserResource
import de.usermanager.repository.UserRepository
import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
open class UserService(
        @Autowired private val userRepository: UserRepository
) : CrudService<UserResource> {
    private val modelMapper = ModelMapper()

    private inline fun <reified T> genericType() = object : TypeToken<T>() {}.type!!

    override fun findAll(): ResponseEntity<List<UserResource>> {
        val fetchedUsers = userRepository.findAll()
        val users = modelMapper.map<List<UserResource>>(fetchedUsers,
                genericType<List<UserResource>>())
                ?: return notFound()
        return ResponseEntity.ok(users)
    }

    override fun findById(id: Long): ResponseEntity<UserResource> {
        val fetchedUser = userRepository.findById(id)
        val user = modelMapper.map(fetchedUser, UserResource::class.java)
                ?: return notFound()
        return ResponseEntity.ok(user)
    }

    private fun <T> notFound(): ResponseEntity<T> {
        return ResponseEntity.notFound().build()
    }
}