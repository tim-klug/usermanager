package de.usermanager.controller

import de.usermanager.viewModel.User

class UserStub {
    companion object {
        fun list(): List<User> {
            return mutableListOf<User>()
        }

        fun get(id: Long): User {
            return User()
        }

        fun create(user: User): User {
            return User()
        }

        fun update(id: Long, user: User): User {
            return user
        }

        fun delete(id: Long): User {
            return get(id)
        }
    }
}