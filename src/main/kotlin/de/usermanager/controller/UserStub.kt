package de.usermanager.controller

import de.usermanager.controller.resources.UserResource

class UserStub {
    companion object {
        fun list(): List<UserResource> {
            return mutableListOf<UserResource>()
        }

        fun get(id: Long): UserResource {
            return UserResource()
        }

        fun create(user: UserResource): UserResource {
            return UserResource()
        }

        fun update(id: Long, user: UserResource): UserResource {
            return user
        }

        fun delete(id: Long): UserResource {
            return get(id)
        }
    }
}