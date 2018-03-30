package de.usermanager.repository

import de.usermanager.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface UserRepository: JpaRepository<User, Long> {
}